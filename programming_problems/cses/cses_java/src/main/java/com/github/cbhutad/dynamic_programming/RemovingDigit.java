package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemovingDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long count = solution(n);
        System.out.println(count);
    }

    private static long solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1;i <= n;i++) {
            dp[i] = 1000000000;

            int num = i;

            while (num > 0) {
                int digit = num % 10;
                num = num / 10;

                dp[i] = Math.min(dp[i], dp[i - digit] + 1);
            }
        }

        return dp[n];
    }
}
