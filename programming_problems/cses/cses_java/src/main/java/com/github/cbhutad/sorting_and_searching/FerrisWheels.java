package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FerrisWheels {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        long[] x = new long[n];
        inputs = br.readLine().split(" ");

        for (int i = 0;i < n;i++) {
            x[i] = Long.parseLong(inputs[i]);
        }

        long count = solution(n, m, x);
        System.out.println(count);
    }
    
    private static long solution(int n, int m, long[] x) {
        // long count = 0;
        // Arrays.sort(x);

        // for (int i = 0;i < x.length;i++) {
        //     if (x[i] != -1) {
        //         for (int j = i + 1;j < x.length;j++) {
        //             if (x[j] != -1 && x[i] + x[j] == m) {
        //                 count++;
        //                 x[i] = -1;
        //                 x[j] = -1;
        //                 break;
        //             }
        //         }
        //     }
        // }

        // //System.out.println(Arrays.toString(x));

        // int idx1 = 0, idx2;

        // while (idx1 < x.length) {
        //     if (x[idx1] != -1) {
        //         idx2 = idx1 + 1;
        //         while (idx2 < x.length) {
        //             if (x[idx2] != -1) {
        //                 if (x[idx1] + x[idx2] < m) {
        //                     x[idx1] = -1;
        //                     x[idx2] = -1;
        //                     count++;
        //                     idx1 = idx2 + 1;
        //                     break;
        //                 }
        //             } 
        //             idx2++;
                    
        //         }
        //         if (idx2 == x.length) {
        //             count++;
        //             idx1++;
        //         }
        //     } else {
        //         idx1++;
        //     }
        // }

        // //        System.out.println(Arrays.toString(x));

        // return count;

         Arrays.sort(x);

        int l = 0;
        int r = n - 1;
        long count = 0;

        while (l <= r) {
            if (x[l] + x[r] <= m) {
                l++;
            }
            r--;
            count++;
        }

        return count;
     }
}
