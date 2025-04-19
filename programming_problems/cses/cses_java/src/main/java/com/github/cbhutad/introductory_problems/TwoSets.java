package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSets {
    public static String solution(long t) {
        long sum = (t * (t + 1)) / 2;
        StringBuilder sb = new StringBuilder();
		if (sum % 2 != 0) {
			sb.append("NO");
		} else {
            sb.append("YES\n");
			long num1 = t;
			long count1 = 0, count2 = 0;
			long num2 = t - 1;
			boolean turn = false;
			StringBuilder sb1 = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			while (num1 > 0) {
				sb1.append(num1 + " ");
				if (!turn) {
					num1 = num1 - 3;
					turn = true;
				} else {
					num1 = num1 - 1;
					turn = false;
				}
				count1 = count1 + 1;
			}
			turn = false;
			sb.append(count1 + "\n");
			sb.append(sb1.toString() + "\n");
			while (num2 > 0) {
				sb2.append(num2 + " ");
				if (!turn) {
					num2 = num2 - 1;
					turn = true;
				} else {
					num2 = num2 - 3;
					turn = false;
				}
				count2 = count2 + 1;
			}
			sb.append(count2 + "\n");
			sb.append(sb2.toString().trim());
        }
        return sb.toString();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		solution(t);
    }
}
