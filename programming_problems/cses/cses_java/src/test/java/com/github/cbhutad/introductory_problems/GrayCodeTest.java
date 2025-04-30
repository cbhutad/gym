package com.github.cbhutad.introductory_problems;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class GrayCodeTest {
    @Test
    public void testcase1() {
        List<String> result = GrayCode.solution(1);
        List<String> expected = Arrays.asList("0", "1");
        assertEquals(expected, result);
    }
}
