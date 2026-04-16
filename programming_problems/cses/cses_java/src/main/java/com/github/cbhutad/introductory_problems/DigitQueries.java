package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DigitQueries {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        long[] k = new long[q];

        for (int i = 0;i < q;i++) {
            k[i] = Long.parseLong(br.readLine());
        }

        solution(q, k);
    }

    private static void solution(int q, long[] k) {
        for (long entry : k) {
            long len = 1;
            long count = 9;
            long start = 1;

            while (entry > (len * count)) {
                entry = entry - (len * count);
                len++;
                count *= 10;
                start *= 10;
            }

            long number = start + (entry - 1) / len;

            String s = String.valueOf(number);
            System.out.println(s.charAt((int)((entry - 1) % len)));
        }

    }
}
