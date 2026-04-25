package com.github.cbhutad.sorting_and_searching;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephousProblemI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder("");
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1;i <= n;i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            queue.add(queue.poll());
            sb.append(queue.poll() + " ");
        }

        System.out.println(sb.toString().trim());
    }    
}
