package algorithm.day28;

class Day28 {
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        int n = users.length;
        int m = emoticons.length;
    
        int[] answer = new int[2];
        int[] rates = {10, 20, 30, 40};
        
        // 1순위가 가입자 늘리기 2순위가 판매액 늘리기 
        int[] discounts = new int[m];
        for (int mask = 0; mask < (1 << (2 * m)); mask++) {
            int sub = 0;
            int totalCost = 0;
            
            for (int i = 0; i < m; i++) {
                discounts[i] = rates[(mask >> (2*i)) & 3];
            }
            
            for (int[] user : users) {
                int minRate = user[0];
                int maxCost = user[1];
                
                int userSpent = 0;
                for (int i = 0; i < m; i++) {
                    if (discounts[i] >= minRate) {
                        userSpent += emoticons[i] * (1 - ((double) discounts[i] / 100));
                    }
                }
                
                if (userSpent >= maxCost) {
                    sub += 1;
                } else {
                    totalCost += userSpent;
                }
            }
            
            if (sub > answer[0] || (sub == answer[0] && totalCost > answer[1])) {
                answer[0] = sub;
                answer[1] = totalCost;
            }
        }
        
        return answer;
    }
}