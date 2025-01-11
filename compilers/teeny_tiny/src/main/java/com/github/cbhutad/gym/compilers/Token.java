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

    public static TokenType checkIfKeyword(String tokenText) {
        for (TokenType type : TokenType.values()) {
            if (type.toString().equals(tokenText) && type.getTokenValue() >= 101 && type.getTokenValue() <= 111) {
                return type;
            }
        }
        return TokenType.NOTKEYWORD;
    }

    @Override
    public String toString() {
        return kind.toString();
    }
}