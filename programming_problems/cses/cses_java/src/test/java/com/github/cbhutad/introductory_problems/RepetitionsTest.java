package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepetitionsTest {
    @Test
    public void testcase1() {
        long count = Repetitions.solution("ATTCGGGA");
        assertEquals(3, count);
    }

    @Test
    public void testcase2() {
        long count = Repetitions.solution("ACACACACAC");
        assertEquals(1, count);
    }

    @Test
    public void testcase3() {
        long count = Repetitions.solution("ACCGGGTTTT");
        assertEquals(4, count);
    }

    @Test
    public void testcase4() {
        long count = Repetitions.solution("AAAACCCGGT");
        assertEquals(4, count);
    }

    @Test
    public void testcase5() {
        long count = Repetitions.solution("CTCAGGTCCG");
        assertEquals(2, count);
    }

    @Test
    public void testcase6() {
        long count = Repetitions.solution("A");
        assertEquals(1, count);
    }
}
