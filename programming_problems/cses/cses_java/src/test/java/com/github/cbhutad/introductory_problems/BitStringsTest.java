package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitStringsTest {
    @Test
    public void testcase1() {
        String result = BitStrings.solution(1);
        assertEquals("2", result);
    }

    @Test
    public void testcase2() {
        String result = BitStrings.solution(1000000);
        assertEquals("235042059", result);
    }
}
