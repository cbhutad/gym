package com.github.cbhutad.gym.compilers;

public class App {

    public static void main(String[] args) {

        Lexer lex = new Lexer(args[0]);
        Token token = lex.getToken();

        while (token.getKind() != TokenType.EOF) {
            System.out.println(token.toString());
            token = lex.getToken();
        }
    }

}
