package algorithm.day27;

import java.io.*;
import java.util.*;

public class Day27 {

    private static class Road {
        int start;
        int end;
        int road;

        public Road(int start, int end, int road) {
            this.start = start;
            this.end = end;
            this.road = road;
        }
    }

    static int n, d;
    static Map<Integer, List<Road>> roads = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());

            if (end > d) {
                continue;
            }

            roads.putIfAbsent(start, new ArrayList<>());
            roads.get(start).add(new Road(start, end, road));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {

        int[] dists = new int[d+1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[0] = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        pQ.offer(0);

        while (!pQ.isEmpty()) {
            int cur = pQ.poll();

            if (cur == d) break;

            if (cur + 1 <= d && dists[cur + 1] > dists[cur] + 1) {
                dists[cur+1] = dists[cur] + 1;
                pQ.offer(cur+1);
            }

            for (Road nextRoad : roads.getOrDefault(cur, new ArrayList<>())) {
                if (dists[nextRoad.end] > dists[cur] + nextRoad.road) {
                    dists[nextRoad.end] = dists[cur] + nextRoad.road;
                    pQ.offer(nextRoad.end);
                }
            }
        }

        return dists[d];
    }   
}
