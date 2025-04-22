package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TrailingZeros {
    public static int solution(int n) {
        int i = 0, pow = 1;
		while (pow <= n) {
			pow *= 5;
			i += 1;
		}

		int maxPower = pow / 5;
		int totalZeros = 0;
		while (maxPower != 1 && maxPower > 2) {
			totalZeros += (n / maxPower);
			maxPower = maxPower / 5;
		}

		return totalZeros;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
}
