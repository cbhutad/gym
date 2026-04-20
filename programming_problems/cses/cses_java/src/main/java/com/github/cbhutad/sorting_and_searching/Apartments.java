package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] ps = new int[n]; // applicant preferences
        int[] aps = new int[m]; // apartment sizes
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ps[i] = Integer.parseInt(st.nextToken());
        }
 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            aps[i] = Integer.parseInt(st.nextToken());
        }
 
        solution(n,m,k,ps,aps);

    }

    private static void solution(int n,int m,int k, int[] ps, int[] aps) {
        Arrays.sort(aps);
        Arrays.sort(ps);
        int count = 0, i = 0, j = 0;
        while (i < n && j < m) {
            if (Math.abs(ps[i] - aps[j]) <= k) {
                count++;
                i++;
                j++;
            } else if (k < (ps[i] - aps[j])) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}
