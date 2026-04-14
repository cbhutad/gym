package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GrayCode {
    public static List<String> solution(int input) {

        if (input == 1) {
            return Arrays.asList("0", "1");
        }

        List<String> code = new ArrayList<>();
        List<String> prev = solution(input - 1);

        for (String s : prev) {
            code.add("0" + s);
        }

        Collections.reverse(prev);

        for (String s : prev) {
            code.add("1" + s);
        }

        return code;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> entries = solution(n);
        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
