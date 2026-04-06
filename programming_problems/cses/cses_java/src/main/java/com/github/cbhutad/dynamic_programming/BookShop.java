package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookShop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int x = Integer.parseInt(strs[1]);

        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");

        int[] prices = new int[n];
        int[] pages = new int[n];

        for (int i = 0;i < n;i++) {
            prices[i] = Integer.parseInt(str1[i]);
            pages[i] = Integer.parseInt(str2[i]);
        }

        long maxPages = solution(n, x, prices, pages);
        System.out.println(maxPages);

    }    

    private static long solution(int n , int x, int[] prices, int[] pages) {

        long[] dp = new long[x + 1];
        dp[0] = 0;

        for (int i = 0;i < n;i++) {
            for (int j = x;j >= prices[i];j--) {
                dp[j] = Math.max(dp[j], dp[j - prices[i]] + pages[i]);
            }
        }
        return dp[x];

    }
}
