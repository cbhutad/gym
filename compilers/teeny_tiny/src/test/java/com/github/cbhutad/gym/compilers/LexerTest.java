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
		String source = "+- */ >>= = !=";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "MINUS", "ASTERISK", "SLASH", "GT", "GTEQ", "EQ", "NOTEQ", "NEWLINE");

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

	@Test
	public void testComments() {
		String source = "+/ # This is a comment\n *-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "NEWLINE", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while (token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(expected, result);
	}

	@Test
	public void testString() {
		String source = "+/ # This is a comment\n \" This is a new string added\" *-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "NEWLINE", "STRING", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while(token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(result, expected);
	}

	@Test
	public void testNumber1() {
		String source = "+/ # This is a comment\n \" This is a new string added\" 1234 *-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "NEWLINE", "STRING", "NUMBER", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while(token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(result, expected);
	}

	@Test
	public void testNumber2() {
		String source = "+/ # This is a comment\n \" This is a new string added\" 1234.56 *-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "NEWLINE", "STRING", "NUMBER", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while(token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(result, expected);
	}

	@Test
	public void checkKeyword() {
		String source = "+/ LET PRINT # This is a comment\n \" This is a new string added\" 1234.56 *-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "LET", "PRINT", "NEWLINE", "STRING", "NUMBER", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while (token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(expected, result);
	}

	@Test
	public void checkIdentifiers() {
		String source = "+/ nums num1 # This is a comment\n \" This is a new string added\" 1234.56 *-";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("PLUS", "SLASH", "IDENT", "IDENT", "NEWLINE", "STRING", "NUMBER", "ASTERISK", "MINUS", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while (token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(expected, result);
	}

	@Test
	public void checkAllTokens() {
		String source = "IF+-123 foo*THEN/";
		List<String> result = new ArrayList<>();
		List<String> expected = Arrays.asList("IF", "PLUS", "MINUS", "NUMBER", "IDENT", "ASTERISK", "THEN", "SLASH", "NEWLINE");

		Lexer lex = new Lexer(source);
		Token token = lex.getToken();

		while (token.getKind() != TokenType.EOF) {
			result.add(token.toString());
			token = lex.getToken();
		}

		assertEquals(expected, result);
	}
	
}