import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        if(arr.length == 0) return arr;
        List<Integer> answerlist = new ArrayList<>();
        answerlist.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]) answerlist.add(arr[i]); 
        }    
        int[] answer = new int[answerlist.size()];
        for (int i = 0; i < answerlist.size(); i++) {
            answer[i] = answerlist.get(i);
        }
        return answer;
    }
}