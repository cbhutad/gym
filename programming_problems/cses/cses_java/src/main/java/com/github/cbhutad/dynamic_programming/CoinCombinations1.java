package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinCombinations1 {
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

        long count = solution(x, coins);
        System.out.println(count);
    }

    private static long solution(int x, int[] coins) {
        long[] count = new long[x + 1];
        count[0] = 1;

        for (int i = 1;i <= x;i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    count[i] = (count[i] + count[i - coin]) % 1000000007;
                }
            }
        }

        return count[x];

    }
}
