package com.github.cbhutad.introductory_problems;

import java.util.ArrayList;
import java.util.List;

public class WeirdAlgorithm {
    public static List<Long> solution(long n) {
        List<Long> nums = new ArrayList<>();
        while (n != 1) {
            nums.add(n);
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
        }
        nums.add((long)1);
        return nums;
    }
}
