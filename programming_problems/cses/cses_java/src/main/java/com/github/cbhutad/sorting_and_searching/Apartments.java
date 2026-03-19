package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        long k;
        long[] wants, sizes;
        String[] strs = br.readLine().split(" ");

        n = Integer.parseInt(strs[0]);
        m = Integer.parseInt(strs[1]);
        k = Long.parseLong(strs[2]);

        wants = new long[n];
        strs = br.readLine().split(" ");
        int index = 0;
        for (String str: strs) {
            wants[index++] = Long.parseLong(str);
        }
        sizes = new long[m];
        strs = br.readLine().split(" ");
        index = 0;
        for (String str : strs) {
            sizes[index++] = Long.parseLong(str);
        }

        long count = solution(n,m,k, wants, sizes);
        System.out.println(count);

    }

    private static long solution(int n, int m, long k, long[] wants, long[] sizes) {
        Arrays.sort(wants);
        Arrays.sort(sizes);
        //System.out.println(Arrays.toString(wants));
        
        int i = 0, j = 0;
        long count = 0;

        while (i < n && j < m) {
            long want = wants[i];
            long size = sizes[j];

            if (size < want - k) {
                j++;
            } else if (size > want + k) {
                i++;
            } else {
                count++;
                i++;
                j++;
            }

        }

        return count;
    }
}
