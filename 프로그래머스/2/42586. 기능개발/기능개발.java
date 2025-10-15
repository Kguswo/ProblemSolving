import java.util.*;
import java.lang.*;

class Solution {
    static int len;
    public int[] solution(int[] progresses, int[] speeds) {
        len = progresses.length;
        
        int[] arr = new int[len];
        
        if((100-progresses[0]) % speeds[0] == 0) arr[0] = (100-progresses[0]) / speeds[0];
        else arr[0] = (100-progresses[0]) / speeds[0] +1;
        
        for(int i=1; i<len; i++){
            int tmp = (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i] == 0) arr[i] = Math.max(tmp, arr[i-1]);
            else arr[i] = Math.max(1 + tmp, arr[i-1]);
        }
        
        int[] count = new int[101];
        
        for(int a : arr){
            count[a]++;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int c : count){
            if(c != 0) list.add(c);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}