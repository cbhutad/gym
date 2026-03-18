package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoinCombinations2 {
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
        int values[] = new int[x + 1];
        values[0] = 1;
        for (int j : coins) {    
            for (int i = j; i <= x;i++) {
               values[i] = (values[i] + values[i - j]) % 1000000007;
            }
            //System.out.println(Arrays.toString(values));
        }
        return values[x];
    }
}