package algorithm.day24;

import java.io.*;
import java.util.*;

public class Day24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] weights = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weights);

        int sumW = 0;
        for (int weight : weights) {
            if (weight > sumW + 1) {
                System.out.println(sumW+1);
                return;
            }

            sumW += weight;
        }

        System.out.println(sumW+1);
    }
}
