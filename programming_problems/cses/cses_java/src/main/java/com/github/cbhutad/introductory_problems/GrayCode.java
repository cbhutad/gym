package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static List<String> solution(int input) {
        List<String> results = new ArrayList<>();
        Long value = (long)Math.pow(2, input);
		
		for (long i = 0;i < value;i++) {
			String result = Long.toBinaryString(i);
			if (result.length() < input) {
				result = "0".repeat(input - result.length()) + result;
			}
			results.add(result);
			result = "";
		}
        return results;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
}
