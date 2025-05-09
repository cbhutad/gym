package com.github.cbhutad.introductory_problems;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class GrayCodeTest {
    @Test
    public void testcase1() {
        List<String> result = GrayCode.solution(2);
        List<String> expected = Arrays.asList("00", "01", "10", "11");
        assertEquals(expected, result);
    }
}
