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

}
