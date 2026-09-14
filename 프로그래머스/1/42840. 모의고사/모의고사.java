import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score1=0, score2=0, score3=0;
        
        for (int i=0; i<answers.length; i++) {
            if (answers[i] == arr1[i % arr1.length]) score1++;
            if (answers[i] == arr2[i % arr2.length]) score2++;
            if (answers[i] == arr3[i % arr3.length]) score3++;
        }
        
        List<Integer> list = new ArrayList<>();
        int max = Math.max(score1, Math.max(score2, score3));
        if (score1 == max) list.add(1);
        if (score2 == max) list.add(2);
        if (score3 == max) list.add(3);
        
        int[] res = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}