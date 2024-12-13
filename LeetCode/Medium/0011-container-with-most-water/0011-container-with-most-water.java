import java.util.*;
import java.io.*;

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int width = right-left;
        int res = 0;
        while(left < right){
            int leftH = height[left];
            int rightH = height[right];
            int minH = Math.min(leftH, rightH);
            int S = width * minH;
            res = Math.max(res, S);

            if(leftH < rightH) left++; 
            else right--;
            width--;
        }
        System.out.println(res);
        return res;
    }
}