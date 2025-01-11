package com.github.cbhutad.gym.compilers;

import java.util.regex.Pattern;

public class Lexer {

	private String source;
	private char currentCharacter;
	private int currentPosition;

	public Lexer(String source) {
		this.source = source + "\n";
		this.currentCharacter = ' ';
		this.currentPosition = -1;
		this.nextCharacter();
	}

	public void nextCharacter() {
		this.currentPosition += 1;
		if (this.currentPosition >= this.source.length()) {
			this.currentCharacter = '\0';
		} else {
			this.currentCharacter = this.source.charAt(this.currentPosition);
		}
	}

	public char peek() {
		if (this.currentPosition + 1 >= this.source.length()) {
			return '\0';
		}
		return this.source.charAt(this.currentPosition + 1);
	}

	public char getCurrentCharacter() {
		return this.currentCharacter;
	}

	public void abort(String message) {
		System.out.println("Lexing error. " + message);
		System.exit(-1);
	}

	public void skipWhitespaces() {
		while (this.currentCharacter == ' ' || this.currentCharacter == '\t' || this.currentCharacter == '\r') {
			this.nextCharacter();
		}
	}

	public void skipComments() {
		if (this.currentCharacter == '#') {
			while (this.currentCharacter != '\n') {
				this.nextCharacter();
			}
		}
	}

	private static boolean checkDigit(char ch) {
		return Pattern.matches("\\d", ch + "");
	}

	public Token getToken() {

		this.skipWhitespaces();
		this.skipComments();

		Token token = null;

		if (this.currentCharacter == '+') {
			token = new Token("+", TokenType.PLUS);
		} else if (this.currentCharacter == '-') {
			token = new Token("-", TokenType.MINUS);
		} else if (this.currentCharacter == '*') {
			token = new Token("*", TokenType.ASTERISK);
		} else if (this.currentCharacter == '/') {
			token = new Token("/", TokenType.SLASH);
		} else if (this.currentCharacter == '\0') {
			token = new Token("\0", TokenType.EOF);
		} else if (this.currentCharacter == '\n') {
			token = new Token("\n", TokenType.NEWLINE);
		} else if (this.currentCharacter == '=') {
			if (this.peek() == '=') {
				this.nextCharacter();
				token = new Token("==", TokenType.EQEQ);
			} else {
				token = new Token("=", TokenType.EQ);
			}
		} else if (this.currentCharacter == '>') {
			if (this.peek() == '=') {
				this.nextCharacter();
				token = new Token(">=", TokenType.GTEQ);
			} else {
				token = new Token(">", TokenType.GT);
			}
		} else if (this.currentCharacter == '<') {
			if (this.peek() == '=') {
				this.nextCharacter();
				token = new Token("<=", TokenType.LTEQ);
			} else {
				token = new Token("<", TokenType.LT);
			}
		} else if (this.currentCharacter == '!') {
			if (this.peek() == '=') {
				this.nextCharacter();
				token = new Token("!=", TokenType.NOTEQ);
			} else {
				this.abort("Expected !=, got !" + this.peek());
			}
		} else if (this.currentCharacter == '"') {
			this.nextCharacter();
			int startPos = this.currentPosition;

			while(this.currentCharacter != '"') {
				if (this.currentCharacter == '\n' || this.currentCharacter == '\t' || this.currentCharacter == '\r' || this.currentCharacter == '%' || this.currentCharacter == '\\') {
					this.abort("Illegal special character inside string.");
				}
				this.nextCharacter();
			}

			token = new Token(this.source.substring(startPos, this.currentPosition), TokenType.STRING);
		} else if (checkDigit(this.currentCharacter)) {
			int startPos = this.currentPosition;

			while (checkDigit(currentCharacter)) {
				this.nextCharacter();
			}

			if (this.currentCharacter == '.') {
				this.nextCharacter();
				if (!checkDigit(this.peek())) {
					this.abort("Illegal character in number.");
				} else {
					while(checkDigit(currentCharacter)) {
						this.nextCharacter();
					}
				}
			}

			token = new Token(this.source.substring(startPos, this.currentPosition + 1), TokenType.NUMBER);
		} else {
			// Unknown token
			this.abort("Unknown token : " + this.currentCharacter);
		}

		this.nextCharacter();
		return token;
	}
}
