package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrailingZerosTest {
    @Test
    public void testcase1() {
        int result = TrailingZeros.solution(1);
        assertEquals(0L, result);
    }

    @Test
    public void testcase2() {
        int result = TrailingZeros.solution(25);
        assertEquals(6L, result);
    }
}
