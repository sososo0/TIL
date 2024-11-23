package algorithm.day26;

import java.util.*;

class Day26 {

    int n; 
    int[][] dice;
    int[] answer;
    double maxRate;
    Map<Integer, int[]> dices = new HashMap<>();
    List<int[]> diceCombs = new ArrayList<>();

    public int[] solution(int[][] dice) {
        n = dice.length;
        answer = new int[n/2];

        this.dice = dice;
        setDice();

        Stack<Integer> stack = new Stack<>();
        setCombs(1, 0, stack);

        rollDice();

        return answer;
    }

    private void setDice() {
        for (int i = 1; i <= n; i++) {
            dices.put(i, dice[i-1]);
        }
    }

    private void setCombs(int num, int idx, Stack<Integer> stack) {
        if (idx == n/2) {
            diceCombs.add(stack.stream().mapToInt(i -> i).toArray());
            return;
        }

        for (int i = num; i <= n; i++) {
            stack.push(i);
            setCombs(i+1, idx+1, stack);
            stack.pop();
        }
    }

    private void rollDice() {
        for (int[] aComb : diceCombs) {
            Set<Integer> totalNums = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                totalNums.add(i);
            }

            for (int a : aComb) {
                totalNums.remove(a);
            }

            int[] bComb = totalNums.stream().mapToInt(i -> i).toArray();    

            Map<Integer, Integer> aScores = calScores(aComb, 0, 0, new HashMap<>());
            Map<Integer, Integer> bScores = calScores(bComb, 0, 0, new HashMap<>());

            double rate = calRate(aScores, bScores);
            if (rate > maxRate) {
                maxRate = rate;
                answer = aComb;
            }

        }
    }

    private Map<Integer, Integer> calScores(int[] comb, int depth, int scoreSum, Map<Integer, Integer> scores) {
        if (depth == comb.length) {
            scores.put(scoreSum, scores.getOrDefault(scoreSum, 0) + 1);
            return scores;
        }
        
        int[] curDice = dices.get(comb[depth]);
        for (int num : curDice) {
            calScores(comb, depth+1, scoreSum+num, scores);
        }

        return scores;
    }

    private double calRate(Map<Integer, Integer> aScores, Map<Integer, Integer> bScores) {
        int totals = 0;
        int wins = 0;
        
        for (Map.Entry<Integer, Integer> aEntry : aScores.entrySet()) {
            for (Map.Entry<Integer, Integer> bEntry : bScores.entrySet()) {
                int aScore = aEntry.getKey();
                int bScore = bEntry.getKey();

                int aFreq = aEntry.getValue();
                int bFreq = bEntry.getValue();

                totals += aFreq*bFreq;
                if (aScore > bScore) {
                    wins += aFreq*bFreq;
                }
            }
        }
        return (double) wins/totals;
    }   
}
