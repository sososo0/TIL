package algorithm.day34;

import java.io.*;

public class Day34 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        int lenA = A.length();
        int lenB = B.length();
        int lenC = C.length();

        int[][][] dp = new int[lenA + 1][lenB + 1][lenC + 1];

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                for (int k = 1; k <= lenC; k++) {
                    if (A.charAt(i-1) == B.charAt(j-1) && B.charAt(j - 1) == C.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }
        
        System.out.println(dp[lenA][lenB][lenC]);
    }
}
