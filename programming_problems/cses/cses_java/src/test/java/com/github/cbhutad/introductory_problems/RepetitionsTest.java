package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepetitionsTest {
    @Test
    public void testcase1() {
        long count = Repetitions.solution("ATTCGGGA");
        assertEquals(3, count);
    }
}
