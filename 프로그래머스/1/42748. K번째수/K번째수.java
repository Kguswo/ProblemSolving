import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++) {
            list.clear();
            
            int start  = commands[i][0];
            int end    = commands[i][1];
            int target = commands[i][2];
            
            for(int idx = (start-1); idx <= (end-1); idx++) {
                list.add(array[idx]);
            }
            
            Collections.sort(list);
            
            answer[i] = list.get(target-1);
        }
        
        return answer;
    }
}