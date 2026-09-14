import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        for (int i=0; i<sizes.length; i++) {
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);
            
            list1.add(a);
            list2.add(b);
        }
        
        int max1 = 0;
        int max2 = 0;
        
        for (int n : list1) {
            max1 = Math.max(max1, n);
        }
        for (int m : list2) {
            max2 = Math.max(max2, m);
        }
        
        return max1 * max2;
    }
}