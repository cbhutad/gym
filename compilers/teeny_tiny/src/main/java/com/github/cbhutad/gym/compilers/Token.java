package com.github.cbhutad.gym.compilers;

public class Token {

    private String text;
    private TokenType kind;

    public Token(String text,TokenType kind) {
        this.text = text;
        this.kind = kind;
    }

    public String getText() {
        return this.text;
    }

    public TokenType getKind() {
        return this.kind;
    }

    @Override
    public String toString() {
        return kind.toString();
    }
}