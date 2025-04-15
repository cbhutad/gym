package com.github.cbhutad.introductory_problems;

public class Repetitions {
    public static long solution(String input) {
        long max = 1;
        long count = 1;
        char cur, prev;
        prev = input.charAt(0);
        
        for(int i = 1;i < input.length(); i++) {
            cur = input.charAt(i);
            if (prev != cur) {
                if (max < count) {
                    max = count;
                }
                count = 1;
            } else {
                count = count + 1;    
            }
            prev = cur;
        }
        if (max < count) {
            max = count;
        }
        return max;
    }
}
