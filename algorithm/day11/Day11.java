package algorithm.day11;

import java.io.*;
import java.util.*;

public class Day11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pqPositive = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        PriorityQueue<Integer> pqNegative = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                pqPositive.offer(num);
            } else {
                pqNegative.offer(Math.abs(num));
            }
        }

        int maxNum = 0;
        if (!pqPositive.isEmpty()) {
            maxNum = Math.max(pqPositive.peek(), maxNum);
        }
        if (!pqNegative.isEmpty()) {
            maxNum = Math.max(pqNegative.peek(), maxNum);
        }
        System.out.println(maxNum);

        int answer = 0;
        while (!pqPositive.isEmpty()) {
            int walk = pqPositive.poll();
            for (int i = 0; i < m-1; i++) {
                pqPositive.poll();

                if (pqPositive.isEmpty()) {
                    break;
                }
            }

            answer += walk*2;
        }

        while (!pqNegative.isEmpty()) {
            int walk = pqNegative.poll();
            for (int i = 0; i < m-1; i++) {
                pqNegative.poll();

                if (pqNegative.isEmpty()) {
                    break;
                }
            }

            answer += walk*2;
        }

        answer -= maxNum;

        System.out.println(answer);

    }
}
