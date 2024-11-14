package algorithm.day18;

import java.util.*;

class Day18 {
    public int solution(int k, int n, int[][] reqs) {
        List<int[]>[] requestsByType = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) {
            requestsByType[i] = new ArrayList<>();
        }
        for (int[] req : reqs) {
            int requestTime = req[0];
            int duration = req[1];
            int type = req[2];
            requestsByType[type].add(new int[] {requestTime, duration});
        }

        int[] mentorAssignments = new int[k + 1];
        Arrays.fill(mentorAssignments, 1);
        int remainingMentors = n - k;

        while (remainingMentors > 0) {
            int minWaitTimeIncrease = Integer.MAX_VALUE;
            int bestType = 1;

            for (int i = 1; i <= k; i++) {
                int currentWaitTime = calculateTotalWaitTime(requestsByType[i], mentorAssignments[i]);
                int newWaitTime = calculateTotalWaitTime(requestsByType[i], mentorAssignments[i] + 1);
                int waitTimeIncrease = newWaitTime - currentWaitTime;

                if (waitTimeIncrease < minWaitTimeIncrease) {
                    minWaitTimeIncrease = waitTimeIncrease;
                    bestType = i;
                }
            }

            mentorAssignments[bestType]++;
            remainingMentors--;
        }

        int answer = 0;
        for (int i = 1; i <= k; i++) {
            answer += calculateTotalWaitTime(requestsByType[i], mentorAssignments[i]);
        }

        return answer;
    }

    private int calculateTotalWaitTime(List<int[]> requests, int mentors) {
        if (requests.isEmpty()) return 0;

        PriorityQueue<Integer> mentorQueue = new PriorityQueue<>();
        for (int i = 0; i < mentors; i++) {
            mentorQueue.add(0); 
        }

        int totalWaitTime = 0;
        for (int[] req : requests) {
            int requestTime = req[0];
            int duration = req[1];

            int availableTime = mentorQueue.poll();
            int waitTime = Math.max(0, availableTime - requestTime);
            totalWaitTime += waitTime;

            mentorQueue.add(Math.max(requestTime, availableTime) + duration);
        }

        return totalWaitTime;
    }
}

