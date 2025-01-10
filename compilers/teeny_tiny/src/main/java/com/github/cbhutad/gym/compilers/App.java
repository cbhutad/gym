package com.github.cbhutad.gym.compilers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        File file = new File(args[0]);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            while (br.ready()) {
                sb.append(br.readLine());
            }

            Lexer lex = new Lexer(sb.toString());
            Token token = lex.getToken();
    
            while (token.getKind() != TokenType.EOF) {
                System.out.println(token.toString());
                token = lex.getToken();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (file.exists()) {
               try {
                   br.close();   
               } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            } 
        }
    }

}
