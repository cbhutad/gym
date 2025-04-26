package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromeReorderTest {
    @Test
    public void testcase1() {
        String result = PalindromeReorder.solution("AAAACACBA");
        assertEquals("AAACBCAAA", result);
    }
}
