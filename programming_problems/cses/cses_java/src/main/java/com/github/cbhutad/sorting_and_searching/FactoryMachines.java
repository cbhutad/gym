package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactoryMachines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int t = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        int[] times = new int[n];

        for (int i = 0;i < n;i++) {
            times[i] = Integer.parseInt(str[i]);
        }

        long left = 0;
        long right = (long)1e18;
        long answer = 0;

        while (left <= right) {
            long mid = (right + left) / 2;

            long products = 0;
            for (int time : times) {
                products += (mid / time);

                if (products >= t) {
                    break;
                }
            }

            if (products >= t) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        
        }

        System.out.println(answer);
    }
}
