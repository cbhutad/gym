package com.github.cbhutad.gym.compilers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        System.out.println("Teeny tiny compiler");
	
	/* Checking if the source file to be compiled is provided or not. If not provided then abort the program with message. */
	if (args.length != 1) {
		System.out.println("Source file for compilation not provided");
		System.exit(1);
	}
	    
	File file = new File(args[0]);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();

            while (br.ready()) {
                sb.append(br.readLine());
		sb.append("\n");
            }

	    /* Initialize the lexer and parser instances */
            Lexer lex = new Lexer(sb.toString());
    	    Parser parser = new Parser(lex);

	    /* call the program function to generate the ast for source code */
            parser.program();

	    System.out.println("Parsing completed");
        
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
