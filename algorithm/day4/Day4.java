package algorithm.day4;

import java.io.*;
import java.util.*;

public class Day4 {

    static int n, m, w;
    static int INF = 1000000000;
    static Map<Integer, List<int[]>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int test = 0; test < tc; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int mi = 0; mi < m; mi++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.get(s).add(new int[] {e, t});
                graph.get(e).add(new int[] {s, t});
            }

            for (int wi = 0; wi < w; wi++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.get(s).add(new int[] {e, -t});
            }

            System.out.println(bellmanFord() ? "YES" : "NO");

        }
    }

    private static boolean bellmanFord() {
        int[] times = new int[n+1];
        Arrays.fill(times, INF);
        times[1] = 0;

        boolean update = false;

        for (int i = 1; i < n; i++) {
            update = false;
            for (int curNode = 1; curNode <= n; curNode++) {
                for (int[] edge : graph.get(curNode)) {
                    int nextNode = edge[0];
                    int nextTime = edge[1];

                    if (times[nextNode] > times[curNode] + nextTime) {
                        times[nextNode] = times[curNode] + nextTime;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            for (int curNode = 1; curNode <= n; curNode++) {
                for (int[] edge : graph.get(curNode)) {
                    int nextNode = edge[0];
                    int nextTime = edge[1];

                    if (times[nextNode] > times[curNode] + nextTime) {
                        return true; 
                    }
                }
            }
        }

        return false;
    }
}


