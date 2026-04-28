package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadingBooks {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] times = new int[n];

        for (int i = 0;i < n;i++) {
            times[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(times);

        solution(n, times);
    }

    private static void solution(int n, int[] times) {
        long sum = 0;

        for (int i = 0;i < n - 1;i++) {
            sum += times[i];
        }

        if (sum < times[n - 1]) {
            System.out.println(times[n - 1] * 2);
        } else {
            System.out.println(times[n - 1] + sum);
        }
    }
}
