import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(people);
        for(int p : people){
            list.add(p);
        }
        
        int res = 0;
        // (제일 무거운 alpha) or (alpha + 가벼운 beta 추가)
        while(!list.isEmpty()){
            if(list.size()>=2 && (list.get(list.size() - 1) + list.get(0)) <= limit){
                list.remove(0);
                list.remove(list.size()- 1);
            }
            else list.remove(list.size()-1);
            
            res++;

        }
        return res;
    }
}