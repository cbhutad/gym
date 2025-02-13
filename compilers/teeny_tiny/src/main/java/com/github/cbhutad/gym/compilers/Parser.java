package com.github.cbhutad.gym.compilers;

import java.util.Set;
import java.util.HashSet;

public class Parser {

	private Lexer lexer;
	private Emitter emitter;
	private Token currentToken;
	private Token peekToken;
	private Set<String> labelsDeclared;
	private Set<String> labelsGotoed;
	private Set<String> symbols;

	public Parser(Lexer lexer, Emitter emitter) {
		this.lexer = lexer;
		this.emitter = emitter;
		this.currentToken = new Token("\\0", TokenType.EOF);
		this.peekToken = new Token("\\0", TokenType.EOF);

		this.labelsDeclared = new HashSet<String>();
		this.labelsGotoed = new HashSet<String>();
		this.symbols = new HashSet<String>();

		this.nextToken();
		this.nextToken(); // called 2 times in order to set the current and peek tokens.
	}

	public boolean checkToken(TokenType kind) {
		return this.currentToken.getKind() == kind;
	}

	public boolean checkPeek(TokenType kind) {
		return this.peekToken.getKind() == kind;
	}

	public void match(TokenType kind) {
		if (!this.checkToken(kind)) {
			this.abort("Expected token kind : " + kind + " got : " + this.currentToken.getKind());
		}
		this.nextToken();
	}

	public void abort(String message) {
		System.out.println("Error. " + message);
		System.exit(1);
	}

	public void nextToken() {
		this.currentToken = this.peekToken;
		this.peekToken = this.lexer.getToken();
	}

	// program ::= {statement}
	public void program() {
		System.out.println("PROGRAM");

		// handling newlines at the start of the program.
		while(checkToken(TokenType.NEWLINE)) {
			this.nextToken();
		}
		
		this.emitter.headerLine("#include <stdio.h>");
		this.emitter.headerLine("int main(void) {");

		while (!checkToken(TokenType.EOF)) {
			this.statement();
		}

		for(String gotoLabel : this.labelsGotoed) {
			if (!this.labelsDeclared.contains(gotoLabel)) {
				this.abort("Attempting to GOTO an undeclared label : " + gotoLabel);
			}
		}

		this.emitter.emitLine("printf(\"Hello World\");");
		this.emitter.emitLine("return 0;");
		this.emitter.emitLine("}");
	}

	public void statement() {
		
		// statement ::= "PRINT" (expression | string) nl
		if (this.checkToken(TokenType.PRINT)) {
			System.out.println("STATEMENT-PRINT");
			this.nextToken();

			if (this.checkToken(TokenType.STRING)) {
				this.nextToken();
			} else {
				this.expression();
			}
		}

		// statement ::= "IF" comparison "THEN" nl {statement} "ENDIF" nl
		else if (this.checkToken(TokenType.IF)) {
			System.out.println("STATEMENT-IF");
			this.nextToken();
			this.comparison();
			this.match(TokenType.THEN);

			this.nl();

			while (!checkToken(TokenType.ENDIF)) {
				this.statement();
			}
		
			this.match(TokenType.ENDIF);
		}

		// statement ::= "WHILE" comparison "THEN" nl {statement} "ENDWHILE" nl
		else if (this.checkToken(TokenType.WHILE)) {
			System.out.println("STATEMENT-WHILE");
			this.nextToken();
			this.comparison();
			this.match(TokenType.THEN);

			this.nl();

			while (!checkToken(TokenType.ENDWHILE)) {
				this.statement();
			}

			this.match(TokenType.ENDWHILE);
		}

		// statement ::= "LABEL" ident nl
		else if (checkToken(TokenType.LABEL)) {
			System.out.println("STATEMENT-LABEL");
			this.nextToken();

			if (this.labelsDeclared.contains(this.currentToken.getText())) {
				this.abort("Label already exists : " + this.currentToken.getText());
			}
			this.labelsDeclared.add(this.currentToken.getText());

			this.match(TokenType.IDENT);
		}

		// statement ::= "GOTO" ident nl
		else if (checkToken(TokenType.GOTO)) {
			System.out.println("STATEMENT-GOTO");
			this.nextToken();
			this.labelsGotoed.add(this.currentToken.getText());
			this.match(TokenType.IDENT);
		}

		// statement ::= "LET" ident "=" expression nl
		else if (checkToken(TokenType.LET)) {
			System.out.println("STATEMENT-LET");
			this.nextToken();
			
			if (!this.symbols.contains(this.currentToken.getText())) {
				this.symbols.add(this.currentToken.getText());
			}

			this.match(TokenType.IDENT);
			this.match(TokenType.EQ);
			this.expression();
		}

		// statement ::= "INPUT" ident nl
		else if (checkToken(TokenType.INPUT)) {
			System.out.println("STATEMENT-INPUT");
			this.nextToken();
			
			if (!this.symbols.contains(this.currentToken.getText())) {
				this.symbols.add(this.currentToken.getText());
			}

			this.match(TokenType.IDENT);
		}

		// Invalid token
		else {
			this.abort("Invalid statement at : " + this.currentToken.getText() + " ( " + this.currentToken.getKind() + " )");
		}

		this.nl();
	}

	// comparison ::= expression (("==" | "!=" | ">" | ">=" | "<" | "<=") expression)+
	public void comparison() {
		System.out.println("COMPARISON");

		this.expression();

		// Atleast one comparison operator with expression should be present
		if (this.isComparisonOperator()) {
			this.nextToken();
			this.expression();
		} else {
			this.abort("Expected atleast one comparison operator at : " + this.currentToken.getText());
		}

		while (this.isComparisonOperator()) {
			this.nextToken();
			this.expression();
		}
	}

	// expression ::= term {("+" | "-") term}
	public void expression() {
		System.out.println("EXPRESSION");

		this.term();

		while (this.checkToken(TokenType.PLUS) || this.checkToken(TokenType.MINUS)) {
			this.nextToken();
			this.term();
		}
	}

	// term ::= unary {("/" | "*") unary}
	public void term() {
		System.out.println("TERM");

		this.unary();

		while (this.checkToken(TokenType.SLASH) || this.checkToken(TokenType.ASTERISK)) {
			this.nextToken();
			this.unary();
		}
	}

	// unary ::= ["+" | "-"] primary
	public void unary() {
		System.out.println("UNARY");

		if (this.checkToken(TokenType.PLUS) || this.checkToken(TokenType.MINUS)) {
			this.nextToken();
		}
		this.primary();
	}
	
	// primary ::= number | ident
	public void primary() {
		System.out.println("PRIMARY + ( " + this.currentToken.getText() + " )");

		if (this.checkToken(TokenType.NUMBER)) {
			this.nextToken();
		} else if (this.checkToken(TokenType.IDENT)) {
			
			if (!this.symbols.contains(this.currentToken.getText())) {
				this.abort("Attempting to reference undeclared identifier : " + this.currentToken.getText());
			}

			this.nextToken();
		} else {
			this.abort("Unexpected token : " + this.currentToken.getText());
		}
	}

	// nl ::= '\n'+
	public void nl() {
		System.out.println("NEWLINE");

		//Atleast one newline character should be present
		this.match(TokenType.NEWLINE);

		// More than one newline characters are allowed
		while (checkToken(TokenType.NEWLINE)) {
			this.nextToken();
		}
	}

	private boolean isComparisonOperator() {
		return this.checkToken(TokenType.EQEQ) || this.checkToken(TokenType.NOTEQ) || this.checkToken(TokenType.GT) || this.checkToken(TokenType.GTEQ) || this.checkToken(TokenType.LT) || this.checkToken(TokenType.LTEQ);
	}

}
