package com.github.cbhutad.tree_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Subordinates {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<List<Integer>>();
        int[] subordinates = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            tree.get(boss).add(i);
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> order = new ArrayList<>();

        stack.add(1);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            order.add(node);
            for (int i : tree.get(node)) {
                stack.push(i);
            }
        }

        for (int i = order.size() - 1; i >= 0; i--) {
            int node = order.get(i);
            for (int j : tree.get(node)) {
                subordinates[node] += subordinates[j] + 1;
            }
        }

        for (int i = 1;i <= n;i++) {
            System.out.print(subordinates[i] + " ");
        }
        System.out.println();

    }
}