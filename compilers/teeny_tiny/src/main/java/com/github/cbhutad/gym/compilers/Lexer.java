package com.github.cbhutad.gym.compilers;

public class Lexer {

	private String source;
	private char currentCharacter;
	private int currentPosition;

	public Lexer(String source) {
		this.source = source + "\n";
		this.currentCharacter = ' ';
		this.currentPosition = -1;
		nextCharacter();
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
		System.out.println("Error. " + message);
		System.exit(-1);
	}

	public Token getToken() {

		Token token = null;

		if (currentCharacter == '+') {
			token = new Token("+", TokenType.PLUS);
		} else if (currentCharacter == '-') {
			token = new Token("-", TokenType.MINUS);
		} else if (currentCharacter == '*') {
			token = new Token("*", TokenType.ASTERISK);
		} else if (currentCharacter == '/') {
			token = new Token("/", TokenType.SLASH);
		} else if (currentCharacter == '\0') {
			token = new Token("\0", TokenType.EOF);
		} else if (currentCharacter == '\n') {
			token = new Token("\n", TokenType.NEWLINE);
		} else {
			// Unknown token
			abort("Unknown token : " + currentCharacter);
		}

		nextCharacter();
		return token;
	}
}
