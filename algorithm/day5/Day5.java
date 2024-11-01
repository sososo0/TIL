package algorithm.day5;

import java.io.*;
import java.util.*;

public class Day5 {

    public static class Flower implements Comparable<Flower> {
        private int start;
        private int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower otherFlower) {
            if (this.start != otherFlower.start) return Integer.compare(this.start, otherFlower.start);
            return Integer.compare(this.end, otherFlower.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken())*100 + Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers);

        int answer = 0;
        int currentEndDate = 301;
        int endMaxDate = 301; 
        int idx = 0;
        while (currentEndDate <= 1130) {
            boolean flag = false; 

            while (idx < n && flowers[idx].start <= currentEndDate) {
                endMaxDate = Math.max(endMaxDate, flowers[idx].end);
                idx ++;
                flag = true;
            }

            if (!flag) {
                System.out.println(0);
                return;
            }

            answer += 1;
            currentEndDate = endMaxDate;
        }

        System.out.println(answer);
    }
}
