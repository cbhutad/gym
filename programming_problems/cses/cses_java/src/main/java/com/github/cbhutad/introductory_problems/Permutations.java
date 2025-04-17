package com.github.cbhutad.introductory_problems;

public class Permutations {
    public static String solution(int n) {
        String result = "";
        
        if (n >= 4 || n == 1) {
			StringBuffer sb1 = new StringBuffer("");
			StringBuffer sb2 = new StringBuffer("");
			
			for (int i = 1;i <= n ;i++) {
				if (i % 2 == 0) {
					sb2.append(i + " ");
				} else {
					sb1.append(i + " ");
				}
			}

			result = sb2.toString() + sb1.toString().trim();

		} else {
			result = "NO SOLUTION";
		}

        return result;
    }
}
