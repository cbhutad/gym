package com.github.cbhutad.gym.compilers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

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

	@Test
	public void testOperators() {
		String source = "+/*-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while (token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(expected, result);
	}

	@Test
	public void testWhitespaceHandling() {
		String source = "+/ *-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while (token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(expected, result);
	}
	
}