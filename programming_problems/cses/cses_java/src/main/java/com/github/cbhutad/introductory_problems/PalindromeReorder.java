package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeReorder {
    public static String solution(String input) {
        int[] charcounts = new int[26];
		for(int i = 0;i < input.length();i++) {
			charcounts[input.charAt(i) - 'A']++;
		}
		int oddcount = 0;

		for(int i = 0;i < 26;i++) {
			if(charcounts[i] != 0) {
				if (charcounts[i] % 2 != 0)
					oddcount++;
			}
		}

		if (oddcount > 1) {
			return "NO SOLUTION";
		} else {
			StringBuilder sb = new StringBuilder("");
			int oddpos = -1, mid = 0;
			for (int i = 0;i < 26;i++) {
				if (charcounts[i] != 0) {
					if (charcounts[i] % 2 == 0) {
						String ch = (char)(65 + i) + "";
						//System.out.println(ch + " " + mid);
						if (mid == 0) {
							sb.append(ch.repeat(charcounts[i]));
						} else {
							sb.insert(mid, ch.repeat(charcounts[i]));
						}
						mid += charcounts[i] / 2;
					} else if (charcounts[i] % 2 != 0) {
						oddpos = i;
					}
				}
			}

			if(oddpos != -1) {
				String ch = (char)(65 + oddpos) + "";
				sb.insert(mid,ch.repeat(charcounts[oddpos]));
			}
			return sb.toString();
		}
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		solution(input);
    }
}
