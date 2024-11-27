package algorithm.day31;

import java.io.*;
import java.util.*;

public class Day31 {

    private static class Node {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static int n, m;
    static Map<Integer, List<Node>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pQ = new PriorityQueue<>((n1, n2) -> (n1.cost - n2.cost));
        pQ.offer(new Node(1, 0));

        while(!pQ.isEmpty()) {
            Node cur = pQ.poll();

            if (cur.cost > dist[cur.node]) continue;

            for (Node nextN : graph.get(cur.node)) {
                if (dist[nextN.node] > dist[cur.node] + nextN.cost) {
                    dist[nextN.node] = dist[cur.node] + nextN.cost;
                    pQ.offer(new Node(nextN.node, dist[nextN.node]));
                }
            }
        }
        return dist[n];
    }
}
