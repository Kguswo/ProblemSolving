import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for(String s : gems){
            gemSet.add(s);            
        }
        int gemKinds = gemSet.size();
        
        Map<String, Integer> gemMap = new HashMap<>();
        int left = 0;
        int right = left;
        int resLeft = 0;
        int resRight = gems.length;
        gemMap.put(gems[0], 1);
        
        while(left <= right && right < gems.length){
            if(gemMap.size() == gemKinds){
                // left 증가
                if((resRight - resLeft) > (right - left)){
                    resRight = right + 1;
                    resLeft = left + 1;
                }
                boolean isLeftCntOne = (gemMap.get(gems[left]) == 1);
                if(isLeftCntOne) gemMap.remove(gems[left]);
                else {
                    int cnt = gemMap.get(gems[left])-1;
                    gemMap.put(gems[left], cnt);
                }
                left++;
            }
            else{
                // right 증가
                right++;
                if(right >= gems.length) break;
                
                gemMap.put(gems[right], gemMap.getOrDefault(gems[right],0) + 1);
            }
        }
        
        int[] ans = {resLeft, resRight};
        return ans;
    }
}