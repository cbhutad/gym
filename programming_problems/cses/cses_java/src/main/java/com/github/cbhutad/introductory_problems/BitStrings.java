package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.io.IOException;

public class BitStrings {
    public static String solution(int n) {
        BigDecimal bg = new BigDecimal(2);
		BigDecimal divisor = new BigDecimal(1000000007);
		bg = bg.pow(n);
		return bg.divideAndRemainder(divisor)[1].toString();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
}
