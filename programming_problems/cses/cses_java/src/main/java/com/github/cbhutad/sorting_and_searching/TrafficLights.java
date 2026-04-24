package com.github.cbhutad.sorting_and_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class TrafficLights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[] str = br.readLine().split(" ");

        TreeSet<Integer> pos = new TreeSet<>();
        TreeMap<Integer, Integer> lengths = new TreeMap<>();

        // initial
        pos.add(0);
        pos.add(x);
        lengths.put(x, 1);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(str[i]);

            // find neighbors
            Integer right = pos.higher(p);
            Integer left = pos.lower(p);

            // remove old segment
            int oldLen = right - left;
            lengths.put(oldLen, lengths.get(oldLen) - 1);
            if (lengths.get(oldLen) == 0) {
                lengths.remove(oldLen);
            }

            // add new segments
            int leftLen = p - left;
            int rightLen = right - p;

            lengths.put(leftLen, lengths.getOrDefault(leftLen, 0) + 1);
            lengths.put(rightLen, lengths.getOrDefault(rightLen, 0) + 1);

            // insert position
            pos.add(p);

            // max segment
            result.append(lengths.lastKey()).append(" ");
        }

        System.out.println(result);
        
    }
}
