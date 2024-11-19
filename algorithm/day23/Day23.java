package algorithm.day23;

import java.io.*;
import java.util.*;
 
public class Day23 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] graph;
    static List<Point> chickenHouses = new ArrayList<>();
    static List<Point> houses = new ArrayList<>();
    static int dist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 2) {
                    chickenHouses.add(new Point(i, j));
                } else if (graph[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }

        Stack<Point> chickens = new Stack<>();
        dfs(chickens, 0, 0);

        System.out.println(dist);
    }

    private static void dfs(Stack<Point> chickens, int idx, int depth) {
        if (depth == m) {
            int calDist = calChickenDist(chickens);
            dist = Math.min(dist, calDist);
            return;
        } 

        for (int i = idx; i < chickenHouses.size(); i++) {
            chickens.push(chickenHouses.get(i));
            dfs(chickens, i+1, depth+1);
            chickens.pop();
        }
    }

    private static int calChickenDist(Stack<Point> chickens) {
        int totalDist = 0;
        for (Point house : houses) {
            int resultDist = Integer.MAX_VALUE;
            for (Point chicken : chickens) {
                int temp = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                resultDist = Math.min(resultDist, temp);
            }
            totalDist += resultDist;
        }

        return totalDist;
    }
}
