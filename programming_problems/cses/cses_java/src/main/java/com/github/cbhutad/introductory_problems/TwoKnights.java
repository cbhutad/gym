package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwoKnights {
    public static List<Long> solution(long t) {
        
        List<Long> list = new ArrayList<>();
        
        for (long i = 1;i <= t;i++) {
			list.add(((i * i) * (i * i - 1) - 8 * (i - 1) * (i - 2)) / 2);
		}

		// My own solution
		// for (int i = 1;i <= t;i++) {
		// 	long total = 0;
			
		// 	long count = -1;
		// 	for (int j = 0;j < i;j++) {
		// 		for (int k = 0;k < i;k++) {
		// 			long dup_count = 0;
		// 			long valid = 0;
		// 			//valid moves check
		// 			if (j - 2 >= 0 && k - 1 >= 0) {
		// 				dup_count++;
		// 				valid++;
		// 			}
		// 			if (j - 2 >= 0 && k + 1 < i) {
		// 				dup_count++;
		// 				valid++;
		// 			}
		// 			if (j - 1 >= 0 && k - 2 >= 0) {
		// 				dup_count++;
		// 				valid++;
		// 			}
		// 			if (j - 1 >= 0 && k + 2 < i) {
		// 				dup_count++;
		// 				valid++;
		// 			}
		// 			if (j + 2 < i && k - 1 >= 0) {
		// 				valid++;
		// 			}
		// 			if (j + 2 < i && k + 1 < i) {
		// 				valid++;
		// 			}
		// 			if (j + 1 < i && k - 2 >= 0) {
		// 				valid++;
		// 			}
		// 			if (j + 1 < i && k + 2 < i) {
		// 				valid++;
		// 			}
		// 			count = count + 1;
		// 			total = total + (i * i - 1) - count + dup_count - valid;
		// 		}
		// 	}
		// 	System.out.println(total);

		// }

        return list;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		solution(t);
    }
}
