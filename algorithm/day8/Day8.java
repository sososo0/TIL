package algorithm.day8;

import java.io.*;
import java.util.*;

public class Day8 {

    private static class Point {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int n;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int orders = 1;
        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijkstra();
            System.out.printf("Problem %d: %d\n", orders, dijkstra());
            orders++;
        }
    }

    private static int dijkstra() {
        boolean[][] visit = new boolean[n][n];
        PriorityQueue<Point> pQ = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        pQ.offer(new Point(0, 0, graph[0][0]));

        while (!pQ.isEmpty()) {
            Point curP = pQ.poll();

            if (curP.x == n-1 && curP.y == n-1) {
                return curP.cost;
            }

            if (visit[curP.x][curP.y]) {
                continue;
            }

            visit[curP.x][curP.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = curP.x + dx[i];
                int ny = curP.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                int nextCost = graph[nx][ny] + curP.cost;
                if (!visit[nx][ny]) {
                    pQ.offer(new Point(nx, ny, nextCost));
                }
            }
        }
        return 0;
    }
}
