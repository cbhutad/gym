package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numIndex = new int[n + 1];
        String[] str = br.readLine().split(" ");

        for(int i = 0;i < n;i++) {
            numIndex[Integer.parseInt(str[i])] = i;
        }

        int rounds = solution(numIndex, n);
        System.out.println(rounds);
    }

    private static int solution(int[] numIndex, int n) {
        int rounds = 1;

        for (int i = 1;i < n;i++) {
            if (numIndex[i] > numIndex[i + 1]) {
                rounds++;
            }
        }

        return rounds;

    }
}
