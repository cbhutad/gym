package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GridPaths1 {

    private static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];

        for (int i = 0;i < n;i++) {
            String str = br.readLine();
            for (int j = 0;j < n;j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        long count = solution(n, grid);
        System.out.println(count);
        
    }

    private static long solution(int n, char[][] grid) {
        int[][] dp = new int[n][n];

        if (grid[0][0] == '.') {
            dp[0][0] = 1;
        }

        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (grid[i][j] == '*') {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 0)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;

                if (j > 0)
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % MOD;
            }
        }
        return dp[n-1][n-1];
    }

}
