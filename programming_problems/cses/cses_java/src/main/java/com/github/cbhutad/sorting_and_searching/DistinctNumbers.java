package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        int index = 0;
        for (String str : br.readLine().split(" ")) {
            nums[index++] = Long.parseLong(str);
        }

        long count = solution(n, nums);
        System.out.println(count);
    }

    private static long solution(int n, long[] nums) {
        long count = 1;
        Arrays.sort(nums);
        for (int i = 0;i < n - 1;i++) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
