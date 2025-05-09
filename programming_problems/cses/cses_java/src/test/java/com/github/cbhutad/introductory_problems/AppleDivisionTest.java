package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppleDivisionTest {
    @Test
    public void testcase1() {
        long[] weights = {3l, 2l, 7l, 4l, 1l};
        assertEquals(1, AppleDivision.solution(weights));
    }
}
