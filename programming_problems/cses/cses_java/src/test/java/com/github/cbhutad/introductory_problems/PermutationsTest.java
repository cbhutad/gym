package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermutationsTest {
    @Test
    public void testcase1() {
        String result = Permutations.solution(5);
        assertEquals("2 4 1 3 5", result);

    }
}
