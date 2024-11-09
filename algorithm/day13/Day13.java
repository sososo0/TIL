package algorithm.day13;

import java.io.*;
import java.util.*;

public class Day13 {

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static char[][] board;
    static int[][] costs;
    static int[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Character, Integer> direct = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        direct.put('U', 0);
        direct.put('D', 1);
        direct.put('L', 2);
        direct.put('R', 3);

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        costs = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], -1);
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == -1) {
                    Stack<Point> path = new Stack<>();
                    answer += dfs(i, j, path);
                }
            }
        }
        
        System.out.println(answer);
    }

    private static int dfs(int x, int y, Stack<Point> path) {
        if (visit[x][y] == 0) {
            return checkCycle(x, y, path);
        } 
        if (visit[x][y] > 0) {
            return 0;
        }

        path.push(new Point(x, y));
        visit[x][y] = 0;
        char dir = board[x][y];
        int idx = direct.get(dir);
        int nx = x + dx[idx];
        int ny = y + dy[idx];

        int minCost = 0;
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
            minCost = dfs(nx, ny, path);
        }

        path.pop();
        visit[x][y] = 1;
        return minCost;
    }

    private static int checkCycle(int x, int y, Stack<Point> path) {
        int minPathCost = Integer.MAX_VALUE;
        boolean flag = false;

        for (Point cur : path) {
            if (cur.x == x && cur.y == y) {
                flag = true;
            }
            if (flag) {
                minPathCost = Math.min(minPathCost, costs[cur.x][cur.y]);
            }
        }
        return minPathCost;
    }
}
