package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistinctNumbers {

    public static long solution(int n, long[] arr) {
        // Step1: sort the array.
        sort(arr, 0, n - 1);
        // Step2: Initialize distinct_nums variable to 1
        long distinct_nums = 1;
        // Step3: Iterate from index 0 to n-2
        for (int i = 0;i < n - 1;i++) {
            // Step4: Compare adjacent elements if arr[i] != arr[i+1] update distinct_nums variable
            if (arr[i] != arr[i + 1]) {
                distinct_nums++;
            }
        }

        return distinct_nums;
    }

    // sort using merge for arr[l...r]
    private static void sort(long[] arr, int l, int r) {
        if (l < r ){
            // calculate the middle index
            int m = (l + r ) / 2;

            // sort the left and right halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private static void merge(long[] arr, int l, int m, int r) {
        // calculcate the size of left and right halves
        int n1 = m - l + 1;
        int n2 = r - m;

        // create temp arrays for left and right
        long[] L = new long[n1];
        long[] R = new long[n2];

        // populate the copies
        for (int i = 0;i < n1;i++)
            L[i] = arr[l + i];
        for (int j = 0;j < n2;j++)
            R[j] = arr[m + 1 + j];

        // index variables for left, right and merged array.
        int i = 0, j = 0, k = l;

        // compare left and right copies till end of one is not reached and placed the sorted value in merged array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // populate the merge array using L[] if any left
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // populate the merge array using L[] if any left
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    private static void input(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        int i = 0;
        String[] nums = br.readLine().split(" ");
        for (String num : nums) {
            arr[i] = Long.parseLong(num);
            i++;
        }
        solution(n, arr);
    }
}
