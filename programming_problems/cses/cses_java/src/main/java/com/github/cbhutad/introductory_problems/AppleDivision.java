package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppleDivision {
    public static long solution(long[] weights) {
        int n = weights.length;
        long total_sum = 0;
        long mindiff = Long.MAX_VALUE;

        for (long weight: weights) {
            total_sum += weight;
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) > 0) {
                    sum += weights[i];
                }
            }

            long diff = Math.abs(2 * sum - total_sum);
            mindiff = Math.min(mindiff, diff);
        }

        return mindiff;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] weights = new long[n];
        int index = 0;
        String[] numsStrings = br.readLine().split(" ");
        for (String str : numsStrings) {
            weights[index] = Long.parseLong(str);
            index++;
        }
        solution(weights);
    }
}
