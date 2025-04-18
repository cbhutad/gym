package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NumberSpiral {
    public static long solution(long x,long y) {
        if (x > y && x % 2 == 0) {
			return (x * x - y + 1);
		} else if (x > y && x % 2 != 0) {
			return ((x - 1) * (x - 1) + y);
		} else if (y > x && y % 2 != 0 ) {
			return (y * y - x + 1);
		} 
		return ((y - 1) * (y - 1) + x);
    }

    // how input is taken for problem as it is also important
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			solution(x, y);
		}
    }
}