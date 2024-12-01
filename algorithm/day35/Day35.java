package algorithm.day35;

import java.util.*;

class Day35 {
    
    int n, coin, round, idx;
    int[] cards;
    Set<Integer> cardsHand = new HashSet<>();
    Set<Integer> cardsDummy = new HashSet<>();
    
    public int solution(int coin, int[] cards) {
        
        n = cards.length;
        this.coin = coin;
        this.cards = cards;
        
        getCardsToHand(0, n/3);
        
        round = 0;
        idx = n/3;
        
        playGame();
        
        return round;
    }
    
    private void getCardsToHand(int start, int end) {
        for (int i = start; i < end; i++) {
            cardsHand.add(cards[i]);
        }
    }
    
    private void playGame() {
        while (true) {
            round++;
            
            if (idx >= n) {
                break;
            }
            
            cardsDummy.add(cards[idx]);
            cardsDummy.add(cards[idx+1]);
            idx += 2;
            
            boolean found = false;
            
            for (int card : cardsHand) {
                if (cardsHand.contains((n+1) - card)) {
                    cardsHand.remove(card);
                    cardsHand.remove((n+1) - card);
                    found = true;
                    break;
                }
            }
            
            if (!found && coin >= 1) {
                for (int card : cardsHand) {
                    if (cardsDummy.contains((n+1) - card)) {
                        cardsDummy.remove((n+1) - card);
                        cardsHand.remove(card);
                        coin -= 1;
                        found = true;
                        break;
                    }
                }
            }
            
            if (!found && coin >= 2) {
                for (int card : cardsDummy) {
                    if (cardsDummy.contains((n+1) - card)) {
                        cardsDummy.remove((n+1) - card);
                        cardsDummy.remove(card);
                        coin -= 2;
                        found = true;
                        break;
                    }
                }
            }
            
            if (!found) {
                break;
            }
        }
    }
}