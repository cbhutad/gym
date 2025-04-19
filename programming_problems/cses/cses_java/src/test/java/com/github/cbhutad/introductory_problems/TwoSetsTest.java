package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TwoSetsTest {
    @Test
    public void testcase1() {
        String result = TwoSets.solution(1L);
        assertEquals(result, "NO");
    }

    @Test
    public void testcase2() {
        String result = TwoSets.solution(3L);
        assertEquals(result, "YES\n" + //
                        "1\n" + //
                        "3 \n" + //
                        "2\n" + //
                        "2 1");
    }
}
