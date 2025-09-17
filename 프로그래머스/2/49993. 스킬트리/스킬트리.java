import java.util.*;

class Solution {
    static Map<Character, Integer> order = new HashMap<>();
    public int solution(String skill, String[] skill_trees) {
        int res = skill_trees.length;
        
        for(int i=0; i<skill.length(); i++){
            order.put(skill.charAt(i), i);
        }
        
        for(String s : skill_trees){
            int curr = -1;
            for(int i=0; i<s.length(); i++){
                if(order.containsKey(s.charAt(i))){
                    int v = order.get(s.charAt(i));
                    if(v != curr+1) {
                        res--;
                        break;
                    }
                    else{
                        curr = v;
                    }
                }
                else continue;
            }
        }
        
        
        return res;
    }
}