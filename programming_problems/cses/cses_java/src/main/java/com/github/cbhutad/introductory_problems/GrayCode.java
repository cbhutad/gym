package com.github.cbhutad.introductory_problems;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GrayCode {
    public static List<String> solution(long n) {
        
        List<String> binaries = new ArrayList<>();

        if (n == 1) {
            binaries.add("0");
            binaries.add("1");
            return binaries;
        }

        int powervalue = (int)Math.pow(2, n);
        Long[] arr = new Long[powervalue];
        int index = -1;
        int indexcount = 1;
        boolean flip = false;
        long count = 0;

        while (index < powervalue) {
            //System.out.println(index + " " + count);
            if (!flip) {
                index = index + 1;
                if (index >= powervalue)
                    break;
                arr[index]  = count * 4;
                arr[index + 1]  = arr[index] + 1;
                arr[index + 2]  = arr[index + 1] + 2;
                arr[index + 3]  = arr[index + 2] - 1;
                flip = true;
            } else {
                index = index + 7;
                if (index >= powervalue)
                    break;
                arr[index]  = count * 4;
                arr[index - 1]  = arr[index] + 1;
                arr[index - 2]  = arr[index - 1] + 2;
                arr[index - 3]  = arr[index - 2] - 1;
                flip = false;
            }
            count = arr[indexcount];
            indexcount++;
        }
        
        for(Long num : arr) {
            String result = Long.toBinaryString(num);
            if (result.length() < n) {
                result = "0".repeat((int)(n - result.length())) + result;
            } 
            binaries.add(result);
        }

        return binaries;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
}