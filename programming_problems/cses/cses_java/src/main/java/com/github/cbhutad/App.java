package com.github.cbhutad;

import java.io.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        long maxLengthSubstring = solution(input);

        System.out.println(maxLengthSubstring);
    }

    private static long solution(String input) {
        long max = 1;
        long count = 1;
        char cur, prev;
        prev = input.charAt(0);
        
        for(int i = 1;i < input.length(); i++) {
            cur = input.charAt(i);
            if (prev != cur) {
                if (max < count) {
                    max = count;
                }
                count = 1;
            } else {
                count = count + 1;    
            }
            prev = cur;
        }
        if (max < count) {
            max = count;
        }
        return max;
    }
}
