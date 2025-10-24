import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> n_set = new HashSet<>();
        for(int num : nums){
            n_set.add(num);
        }
        int half = nums.length / 2;
        if(n_set.size() >= half) return half;
        else return n_set.size();
    }
}