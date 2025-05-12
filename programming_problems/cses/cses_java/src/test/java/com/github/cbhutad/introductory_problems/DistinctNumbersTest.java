package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DistinctNumbersTest {
    @Test
    public void testcase1() {
        long[] arr = {2l ,3l ,2l, 3l ,2l};
        long result = DistinctNumbers.solution(5, arr);
        assertEquals(2, result);
    }
}
