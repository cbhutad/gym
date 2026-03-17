package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long count = solution(n);
        System.out.println(count);
    }        

    private static long solution(int n) {
        long[] count = new long[n + 1];
        count[0] = 1;
        for (int i = 1;i <= n;i++) {
            for (int j = 1;j <= 6;j++) {
                if (i - j >= 0) {
                    count[i] = count[i] + count[i - j];
                }
            }
            count[i] = count[i] % 1000000007;
        }

        return count[n];
    }
}
