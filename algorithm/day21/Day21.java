package algorithm.day21;

import java.io.*;
import java.util.*;
 
public class Day21 {
 
    static int[][] dist;
    static int N, K, ans = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        visited = new boolean[N];
        visited[K] = true;
        dfs(1, K, 0);
        System.out.println(ans);
    }
 
    static void dfs(int cnt, int prev, int d) {
        if (cnt == N) {
            ans = Math.min(ans, d);
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(cnt+1, i, d + dist[prev][i]);
            visited[i] = false;
        }
    }
}