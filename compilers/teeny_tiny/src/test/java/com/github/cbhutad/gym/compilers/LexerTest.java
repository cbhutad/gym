package com.github.cbhutad.gym.compilers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LexerTest {

    @Test
    public void testSimplePeekAndNextChar() {
	    String source = "LET foobar = 123";
		StringBuilder sb = new StringBuilder("");
		
		Lexer lex = new Lexer(source);
		
		while (lex.peek() != '\0') {
			sb.append(lex.getCurrentCharacter());
			lex.nextCharacter();
		}

		assertTrue(source.equals(sb.toString()));
    }
}
