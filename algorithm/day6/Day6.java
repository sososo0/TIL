package algorithm.day6;

import java.io.*;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] students = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            students[i][i] = true;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int student1 = Integer.parseInt(st.nextToken());
            int student2 = Integer.parseInt(st.nextToken());

            students[student1][student2] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (students[i][k] && students[k][j]) {
                        students[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (students[i][j] || students[j][i]) {
                    cnt += 1;
                }
            }

            if (cnt == n) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}
