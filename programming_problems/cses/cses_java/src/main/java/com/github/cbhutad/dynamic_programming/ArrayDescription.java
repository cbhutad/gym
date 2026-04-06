package com.github.cbhutad.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayDescription {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        int[] x = new int[n + 1];
        inputs = br.readLine().split(" ");

        for (int i = 1;i <= n;i++) {
            x[i] = Integer.parseInt(inputs[i - 1]);
        }

        long count = solution(n, m, x);
        System.out.println(count);
    }

    private static long solution(int n, int m, int[] x) {
        long count = 0;

        long[][] dp = new long[n + 1][m + 1];

        if (x[1] != 0) {
            dp[1][x[1]] = 1;
        } else {
            for (int i = 1;i <= m;i++) {
                dp[1][i] = 1;
            }
        }

        for (int i = 2;i <= n;i++) {
            for (int j = 1;j <= m;j++) {
                dp[i][j] = dp[i - 1][j];
                if (j != 1)  {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j != m) {
                    dp[i][j] += dp[i - 1][j + 1];
                }

                dp[i][j] = dp[i][j] % 1000000007;
            }

            if (x[i] != 0) {
                for (int j = 0;j <= m;j++) {
                    if (j != x[i]) {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i <= m;i++) {
            count = (count + (dp[n][i])) % 1000000007;
        }

        return count;
    }
}
