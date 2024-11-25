package algorithm.day29;

import java.io.*;
import java.util.*;

public class Day29 {

    private static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static int n, m;
    static List<Edge> edges = new ArrayList<>();
    static long[] answer;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, cost));
        }

        answer = new long[n+1];
        Arrays.fill(answer, INF);
        answer[1] = 0;

        if (isCycle()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println(answer[i] != INF ? answer[i] : -1);
            }
        }
    }

    private static boolean isCycle() {
        for (int i = 0; i < n-1; i++) {
            for (Edge edge : edges) {
                if (answer[edge.start] != INF && answer[edge.start] + edge.cost < answer[edge.end]) {
                    answer[edge.end] = answer[edge.start] + edge.cost;
                }
            }
        }

        for (int i = 0; i < n-1; i++) {
            for (Edge edge : edges) {
                if (answer[edge.start] != INF && answer[edge.start] + edge.cost < answer[edge.end]) {
                    return true;
                }
            }
        }
        return false;
    }
}
