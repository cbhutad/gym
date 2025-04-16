package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IncreasingArrayTest {
    @Test
    public void testcase1() {
        int[] nums = {6,10,4,10,2,8,9,2,7,7};
        long count = IncreasingArray.solution(10, nums);
        assertEquals(31, count);
    }
}
