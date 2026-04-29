package com.github.cbhutad.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SumOfThreeValues {

    static class Pair {
        long value;
        int index;

        public Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long x = sc.nextLong();

        Pair[] arr = new Pair[n];

        for (int i = 0;i < n;i++) {
            arr[i] = new Pair(sc.nextLong(), i + 1);
        }

        Arrays.sort(arr, Comparator.comparingLong(a -> a.value));

        for (int i = 0;i < n;i++) {
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                long sum = arr[i].value + arr[l].value + arr[r].value;

                if (sum == x) {
                    System.out.println(arr[i].index + " " + arr[l].index + " " + arr[r].index);
                    return;
                } else if (sum < x) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        System.out.println("IMPOSSIBLE");

    }
}
