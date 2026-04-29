package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NearestSmallerValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i = 0;i < n;i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        solution(n, nums);

    }

    private static void solution(int n, int[] nums) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0;i < n;i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append((stack.peek() + 1) + " ");
            }

            stack.push(i);
        }

        System.out.println(sb);
    }
}