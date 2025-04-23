package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinPiles {
    public static String solution(int a, int b) {
        if ((a + b) % 3 == 0) {
			int multiple = (a + b) / 3;
			int max = 2 * multiple;
			int min = 1 * multiple;
			if (max >= a && max >= b && min <= a && min <= b) {
				return "YES";
			}
		}
		return "NO";
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

        int[] a = new int[t];
		int[] b = new int[t];

		int i = 0;
		while(t-- > 0) {

			String[] nums = br.readLine().split(" ");
			int num1 = Integer.parseInt(nums[0]);
			int num2 = Integer.parseInt(nums[1]);

            a[i] = num1;
			b[i] = num2;
			i = i + 1;

		}
		for(int j = 0;j < a.length;j++) {
			solution(a[j], b[j]);
		}
    }
}
