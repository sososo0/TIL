package algorithm.day12;

import java.util.*;

class Day12 {
    public int[] solution(int[][] edges) {

        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (int[] edge : edges) {
            outDegree.put(edge[0], outDegree.getOrDefault(edge[0], 0) + 1);
            inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0) + 1);
        }

        int[] answer = new int[4];

        for (Map.Entry<Integer, Integer> entry : outDegree.entrySet()) {
            if (entry.getValue() > 1) {
                if (!inDegree.containsKey(entry.getKey())) {
                    answer[0] = entry.getKey();
                } else {
                    answer[3] += 1;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (!outDegree.containsKey(entry.getKey())) {
                answer[2] += 1;
            }
        }

        answer[1] = outDegree.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}