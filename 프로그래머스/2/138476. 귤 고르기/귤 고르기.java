import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int res = 0;
        
        Map<Integer, Integer> cMap = new HashMap<>();
        
        for(int t : tangerine){
            cMap.put(t, cMap.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> cList = new ArrayList<>(cMap.values());
        Collections.sort(cList, Collections.reverseOrder());
        
        for(int c : cList){
            if(k<=0) break;
            
            k-=c;
            res++;
        }
        
        return res;
    }
}