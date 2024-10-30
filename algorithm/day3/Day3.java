package algorithm.day3;

import java.io.*;
import java.util.*;

public class Day3 {

    static int n;
    static int[][] graph;
    static int[] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        members = new int[n+1];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == -1 && n2 == -1) {
                break;
            }

            graph[n1][n2] = 1;
            graph[n2][n1] = 1;            
        }

        cntScore();

        int minScore = Integer.MAX_VALUE;
        int minCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (members[i] < minScore) {
                minScore = members[i];
                minCnt = 1;
                sb.setLength(0);
                sb.append(i);
                sb.append(" ");
            } else if (members[i] == minScore) {
                minCnt += 1;
                sb.append(i);
                sb.append(" ");
            }
        }

        System.out.println(minScore + " " + minCnt);
        System.out.println(sb.toString());

    }

    private static void cntScore() {
        for (int i = 1; i <= n; i++) {
            Deque<int[]> dQ = new ArrayDeque<>();
            dQ.offerLast(new int[] {i, 0});
            boolean[] visit = new boolean[n+1];
            visit[i] = true;

            while (!dQ.isEmpty()) {
                int[] cur = dQ.pollFirst();

                int curN = cur[0];
                int dist = cur[1];

                members[i] = Math.max(dist, members[i]);

                for (int j = 1; j <= n; j++) {
                    if (!visit[j] && graph[curN][j] == 1) {
                        visit[j] = true;
                        dQ.offerLast(new int[] {j, dist+1});
                    }
                }
            }
        }
    }
}
