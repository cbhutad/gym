package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n - 1];
        String[] str = br.readLine().split(" ");

        for(int i = 0;i < n - 1;i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        int missingNumber = solution(nums, n);
        System.out.println(missingNumber);
    }
    
    private static int solution(int[] nums, int n) {
        int missingNumber = 0;
        int xorN = 0;

        for (int i = 1;i <= n;i++) {
            xorN = xorN ^ i;
        }

        for (Integer num : nums) {
            xorN = xorN ^ num;
        }

        missingNumber = xorN;

        return missingNumber;
        
    }
}
