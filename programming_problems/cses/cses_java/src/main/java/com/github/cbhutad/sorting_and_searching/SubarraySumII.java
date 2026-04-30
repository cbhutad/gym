package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SubarraySumII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        long s = Integer.parseInt(str[1]);

        int[] nums = new int[n];
        str = br.readLine().split(" ");

        for (int i = 0;i < n;i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        solution(n, nums, s);
    }    

    private static void solution(int n, int[] nums, long s) {
        long prefix = 0;
        long ans = 0;

        HashMap<Long, Long> count = new HashMap<>();
        count.put(0L, 1L);

        for (int i = 0;i < n;i++) {
            prefix += nums[i];

            ans += count.getOrDefault(prefix - s, 0L);

            count.put(prefix, count.getOrDefault(prefix, 0L) + 1);
        }

        System.out.println(ans);
    }
}
