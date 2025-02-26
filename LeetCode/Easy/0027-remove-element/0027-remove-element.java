class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;
        int idx=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val) {
                cnt++;
                nums[idx++] = nums[i];
            }
        }
        return cnt;
    }
}