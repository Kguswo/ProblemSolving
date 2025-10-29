class Solution {
    private static int target;
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        target = n+1;
        
        // 1-based
        boolean[] currCards = new boolean[n+1];
        boolean[] newCards = new boolean[n+1]; // 새로 뽑아서 target 짝지어주기
        
        for(int i=0; i<n/3; i++) {
            currCards[cards[i]] = true;
        }
        
        int cnt = 0;
        int canUseNewCard = 0; // 낼 짝 0개일때 코인써서 낼 수 있는지
        
        for(int i=1; i<=n/2; i++) {
            if(currCards[i] && currCards[(target)-i]) cnt++;
        }
        
        for(int round=1; round<=1 + n/3; round++){ // 12면 1~5까지 가능
            if(round > n/3) return round;
            // 인덱스는 12면 5~12까지 두칸씩 가능
            int card1 = cards[n/3 + (round-1)*2];     // 4, 6, 8, 10
            int card2 = cards[n/3 + (round-1)*2 + 1]; // 5, 7, 9, 11
                
            if(currCards[(target) - card1] && coin>0) {
                cnt++;
                coin--;
            }
            if(currCards[(target) - card2] && coin>0) {
                cnt++;
                coin--;
            }
            
            if(newCards[target - card1]) canUseNewCard++;
            else newCards[card1] = true;
            
            if(newCards[target - card2]) canUseNewCard++;
            else newCards[card2] = true;
            
            if(cnt == 0 && coin >= 2 && canUseNewCard > 0) {
                cnt++;
                coin -=2;
                canUseNewCard--;
            }
            
            if(cnt==0) return round;
            
            cnt--;
        }
        return 1;
    }
}