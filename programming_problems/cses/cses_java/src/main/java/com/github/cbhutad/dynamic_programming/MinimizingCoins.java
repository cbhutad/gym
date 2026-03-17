package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimizingCoins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int x = Integer.parseInt(str[1]);
        int[] coins = new int[n];
        int index = 0;
        for (String s : br.readLine().split(" ")) {
            coins[index++] = Integer.parseInt(s);
        }

        long minCount = solution(x, coins);
        System.out.println(minCount);
    }    

    private static long solution(int x, int[] coins) {

        int[] values = new int[x + 1];
        values[0] = 0;
        for (int i = 1;i <= x; i++) {
            values[i] = 1000000000;
            for (Integer j : coins) {
                if (i - j >= 0) {
                    values[i] = Math.min(values[i], values[i - j] + 1); 
                }
            }
        }
        return values[x] == 1000000000 ? -1 : values[x];
    }
}
