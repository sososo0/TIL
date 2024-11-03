package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Day7 {
    static int n, m;
    static Map<Integer, List<int[]>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(n1).add(new int[] {n2, w});
            graph.get(n2).add(new int[] {n1, w});
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(bfs(start, end));
        }
    }

    private static int bfs(int start, int end) {
        boolean[] visit = new boolean[n+1];
        visit[start] = true;

        Deque<int[]> dQ = new ArrayDeque<>();
        dQ.offerLast(new int[] {start, 0});

        int result = 0;
        while (!dQ.isEmpty()) {
            int[] cur = dQ.pollFirst();
            int curN = cur[0];
            int curW = cur[1];

            if (curN == end) {
                result = curW;
                break;
            }

            for (int[] next : graph.get(curN)) {
                int nextN = next[0];
                int nextW = next[1];

                if (!visit[nextN]) {
                    visit[nextN] = true;
                    dQ.offerLast(new int[] {nextN, curW + nextW});
                }
            }
        }

        return result;
    }
}
