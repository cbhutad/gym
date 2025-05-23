package com.github.cbhutad.introductory_problems;

public class IncreasingArray {
    public static long solution(int n, int[] nums) {
		long count = 0;

		for (int i = 1;i < n;i++) {
			if (nums[i] < nums[i-1]) {
				count = count + nums[i-1] - nums[i];
				nums[i] = nums[i-1];
			}
		}

        return count;
	}
}
