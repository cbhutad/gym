package com.github.cbhutad.gym.compilers;

public class Parser {

	private Lexer lexer;
	private Token currentToken;
	private Token peekToken;

	public Parser(Lexer lexer) {
		this.lexer = lexer;
		this.currentToken = new Token("\\0", TokenType.EOF);
		this.peekToken = new Token("\\0", TokenType.EOF);

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

		while (!checkToken(TokenType.EOF)) {
			this.statement();
		}
	}

	public void statement() {
		
		// statement ::= "PRINT" (expression | string) nl
		if (this.checkToken(TokenType.PRINT)) {
			System.out.println("STATEMENT-PRINT");
			self.nextToken();

			if (this.checkToken(TokenType.STRING)) {
				this.nextToken();
			} else {
				this.expression();
			}

			this.nl();
		}
	}

	// nl ::= '\n'+
	public void nl() {
		System.out.println("NEWLINE");

		//Atleast one newline character should be present
		if (!checkToken(TokenType.NEWLINE)) {
			this.abort("Expected alteast one newline character");
		}
		this.nextToken();

		// More than one newline characters are allowed
		while (!checkToken(TokenType.EOF)) {
			this.nextToken();
		}
	}

}
