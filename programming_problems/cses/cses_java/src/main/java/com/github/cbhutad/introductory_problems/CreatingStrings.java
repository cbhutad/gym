package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatingStrings {

    private static List<String> result = new ArrayList<>();
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        String sortedInput = new String(inputArr);
        used = new boolean[sortedInput.length()];
        StringBuilder current = new StringBuilder("");
        solution(sortedInput, current);
        System.out.println(result.size());
        for (String entry : result) {
            System.out.println(entry);
        }
    }   

    private static void solution(String input, StringBuilder current) {

        if (input.length() == current.length()) {
            result.add(current.toString());
            return;
        }

        for (int i = 0;i < input.length(); i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && input.charAt(i) == input.charAt(i - 1) && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.append(input.charAt(i));

            solution(input, current);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;

        }
    }
}
