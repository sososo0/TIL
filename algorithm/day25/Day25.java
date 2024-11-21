package algorithm.day25;

import java.io.*;
import java.util.*;

public class Day25 {

    static int n, m;
    static int[][] graph, dp, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        dp = new int[n][m];
        temp = new int[2][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = graph[0][0];
        for(int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + graph[0][i];
        }

        for(int i = 1; i < n; i++) {

            temp[0][0] = dp[i-1][0] + graph[i][0];
            for(int j = 1; j < m; j++) {
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + graph[i][j];
            }

            temp[1][m-1] = dp[i-1][m-1] + graph[i][m-1];
            for(int j = m - 2; j >= 0; j--) {
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + graph[i][j];
            }

            for(int j = 0; j < m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
} 
