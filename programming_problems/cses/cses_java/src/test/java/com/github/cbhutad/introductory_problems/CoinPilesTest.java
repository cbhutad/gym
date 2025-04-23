package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoinPilesTest {
    @Test
    public void testcase() {
        String result = CoinPiles.solution(3, 3);
        assertEquals("YES", result);
    }
}
