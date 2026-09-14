import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int ans = 0;
        
        Arrays.sort(citations);
        
        for (int i=0; i<citations.length; i++) {
            int leastTarget = citations.length - i;
            if (citations[i] >= leastTarget) {
                ans = Math.max(ans, ans = leastTarget);
            }
        }
        
        return ans;
    }
}