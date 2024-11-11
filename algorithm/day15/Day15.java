package algorithm.day15;

import java.io.*;
import java.util.*;

public class Day15 {

    public static class Point {
        int x;
        int y;
        int dist;
        
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int n;
    static int[][] grid;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(nums[j]);
            }
        }

        System.out.println(bfs());

    }
    
    private static int bfs() {
        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;
        PriorityQueue<Point> pQ = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
        pQ.offer(new Point(0, 0, 0));

        while(!pQ.isEmpty()) {
            Point cur = pQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int dist = cur.dist;

                if (nx == n-1 && ny == n-1) {
                    return dist;
                }

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                int newDist = cur.dist + (grid[nx][ny] == 1 ? 0 : 1);

                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    pQ.offer(new Point(nx, ny, newDist));
                }
            }
        }
        return 0;
    }
}
