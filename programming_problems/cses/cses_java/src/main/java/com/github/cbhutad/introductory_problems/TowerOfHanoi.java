package com.github.cbhutad.introductory_problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {

    private static int count = 0;
    private static List<String> moves = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int towerA = 1;
        int towerB = 2;
        int towerC = 3;
        solution(towerA, towerC, towerB, n);
        System.out.println(count);
        for (String move : moves) {
            System.out.println(move);
        }
    }
    
    private static void solution(int source, int target, int spare, int n) {
        if (n == 1) {
            moves.add(source + " " + target);
            count++;
        } else {
            solution(source, spare, target, n - 1);
            moves.add(source + " " + target);
            count++;
            solution(spare, target, source, n - 1);
        }
    }
}
