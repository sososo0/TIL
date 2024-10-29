package algorithm.day2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day2 {
    static int n, m;
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] visit;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n+1];
            findB(i);
        }

        int minN = Integer.MAX_VALUE;
        int minP = 0;
        for (int i = 1; i <= n; i++) {
            if (minN > answer[i]) {
                minN = answer[i];
                minP = i;
            }
        }

        System.out.println(minP);

        sc.close();
    }

    private static void findB(int node) {
        Deque<int[]> dQ = new ArrayDeque<>();
        dQ.offerLast(new int[] {node, 0});
        visit[node] = true;

        while (!dQ.isEmpty()) {
            int[] cur = dQ.pollFirst();
            int curN = cur[0];
            int dist = cur[1];

            for (int nextN : graph.get(curN)) {
                if (!visit[nextN]) {
                    visit[nextN] = true;
                    answer[node] += (dist + 1);
                    dQ.offerLast(new int[] {nextN, dist+1});
                }
            }
        }
    }
}
