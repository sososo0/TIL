package algorithm.day9;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Day9 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int n = enroll.length;
        int[] answer = new int[n];
        Map<String, String> partner = new HashMap<>();
        Map<String, Integer> orders = new HashMap<>();
        
        orders = IntStream.range(0, n)
            .boxed()
            .collect(Collectors.toMap(
                i -> enroll[i],
                i -> i
            ));
        
        partner = IntStream.range(0, n)
            .boxed()
            .collect(Collectors.toMap(
                i -> enroll[i],
                i -> referral[i]
            ));
        
        for (int i = 0; i < seller.length; i++) {
            String person = seller[i];
            int getCost = amount[i] * 100; // 판매 금액을 100배로
            
            while (getCost > 0 && !person.equals("-")) {
                int nextCost = getCost/10;
                int curCost = getCost - nextCost;
                answer[orders.get(person)] += curCost; 

                person = partner.get(person);
                getCost = nextCost; 

                if (getCost < 1) break;
            }
        }
        
        return answer;
    }
}
