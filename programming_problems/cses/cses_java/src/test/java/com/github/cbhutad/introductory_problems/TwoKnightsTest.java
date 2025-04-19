package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TwoKnightsTest {
    @Test
    public void testcase1() {
        List<Long> list = TwoKnights.solution(1);
        List<Long> expected = new ArrayList<>();
        expected.add(0L);
        assertEquals(expected, list);
    }

    @Test
    public void testcase2() {
        List<Long> list = TwoKnights.solution(2);
        List<Long> expected = new ArrayList<>();
        expected.add(0L);
        expected.add(6L);
        assertEquals(expected, list);
    }
}
