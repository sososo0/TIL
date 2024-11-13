package algorithm.day17;

import java.io.*;
import java.util.*;

public class Day17 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, List<Integer>> works = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int[] times = new int[n + 1]; 
        int[] dp = new int[n + 1]; 
        for (int node = 1; node <= n; node++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[node] = time;
            dp[node] = time;
            works.put(node, new ArrayList<>());

            int cnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < cnt; i++) {
                int preWork = Integer.parseInt(st.nextToken());
                works.get(node).add(preWork);
            }
        }

        for (int node = 1; node <= n; node++) {
            for (int preWork : works.get(node)) {
                dp[node] = Math.max(dp[node], dp[preWork] + times[node]);
            }
        }

        int result = Arrays.stream(dp).max().orElse(0);
        System.out.println(result);
    }
}
