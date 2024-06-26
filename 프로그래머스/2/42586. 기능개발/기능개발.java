import java.util.*;
import java.lang.Math;

class Solution {
    static int length;
    public int[] solution(int[] progresses, int[] speeds) {
        length = progresses.length;
        int [] arr = new int[length];
        
        if((100-progresses[0]) % speeds[0] == 0) arr[0] = (100-progresses[0]) / speeds[0];
        else arr[0] = (100-progresses[0]) / speeds[0] +1;
        
        for(int i=1; i<length; i++){
            int value = (100-progresses[i]) / speeds[i];
            if((100-progresses[i]) % speeds[i] == 0) arr[i] = Math.max(value, arr[i-1]);
            else arr[i] = Math.max(value+1, arr[i-1]);
        }
        Set<Integer> sizecheck = new HashSet<>();
        for (int a : arr) sizecheck.add(a);
        int size = sizecheck.size();
        
        int[] answer = new int[size];
        int idx = 0;
        int cnt = 1;
        for (int i = 1; i < length; i++) {
            if (arr[i] == arr[i - 1]) cnt++;
            else {
                answer[idx++] = cnt;
                cnt = 1;
            }
        }
        answer[size-1] = cnt;
        return answer;
    }
}