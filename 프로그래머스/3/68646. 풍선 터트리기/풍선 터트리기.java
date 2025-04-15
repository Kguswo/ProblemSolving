import java.util.*;

class Solution {
    public int solution(int[] a) {
        if(a.length<=2) return a.length;
        
        int res = a.length;
        int[] left_min = new int[a.length];
        int[] right_min = new int[a.length];
        
        left_min[0] = Integer.MAX_VALUE;
        for(int i=1; i<a.length; i++){
            left_min[i] = Math.min(left_min[i-1], a[i-1]);
        }

        right_min[a.length-1] = Integer.MAX_VALUE;
        for(int i=a.length-2; i>=0; i--){            
            right_min[i] = Math.min(right_min[i+1], a[i+1]);
        }
        
        for(int i=0; i<a.length; i++){
            if(left_min[i] < a[i] && right_min[i] < a[i]) res--;
        }
        // System.out.println(Arrays.toString(left_min));
        // System.out.println(Arrays.toString(right_min));
        return res;
    }
}