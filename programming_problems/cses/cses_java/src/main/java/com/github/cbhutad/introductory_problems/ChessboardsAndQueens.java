package com.github.cbhutad.introductory_problems;

import java.util.*;

public class ChessboardsAndQueens {
    static String[] board = new String[8];
    static boolean[] col = new boolean[8];
    static boolean[] diag1 = new boolean[15]; // row + col
    static boolean[] diag2 = new boolean[15]; // row - col + 7
    static int ans = 0;

    static void solve(int row) {
        if (row == 8) {
            ans++;
            return;
        }

        for (int c = 0; c < 8; c++) {
            if (board[row].charAt(c) == '*') continue;

            if (col[c] || diag1[row + c] || diag2[row - c + 7])
                continue;

            // place queen
            col[c] = diag1[row + c] = diag2[row - c + 7] = true;

            solve(row + 1);

            // backtrack
            col[c] = diag1[row + c] = diag2[row - c + 7] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            board[i] = sc.next();
        }

        solve(0);
        System.out.println(ans);
    }
}
