package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberSpiralTest {
    @Test
    public void testcase1() {
        long value = NumberSpiral.solution(1, 1);
        assertEquals(1, value);
    }

    @Test
    public void testcase2() {
        long value = NumberSpiral.solution(8, 1);
        assertEquals(64, value);
    }

    @Test
    public void testcase3() {
        long value = NumberSpiral.solution(1, 11);
        assertEquals(121, value);
    }

    @Test
    public void testcase4() {
        long value = NumberSpiral.solution(6, 8);
        assertEquals(55, value);
    }

    @Test
    public void testcase5() {
        long value = NumberSpiral.solution(5, 4);
        assertEquals(20, value);
    }
}
