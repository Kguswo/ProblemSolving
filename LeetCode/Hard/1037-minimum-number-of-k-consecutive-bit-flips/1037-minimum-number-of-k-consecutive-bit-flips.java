class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int left = 0;
        int[] prefixSum = new int[nums.length + 1];
        int cnt = 0;
        int currSum = 0; // 이전 뒤집기 기억해서 지금칸에 몇번 뒤집을지 0~k번 중 반영해야함

        for (int i = 0; i < nums.length; i++) {
            currSum += prefixSum[i];

            int currState = (nums[i] + currSum) % 2;

            if (currState != 1) {
                if (i > nums.length - k) {
                    return -1;
                }

                cnt++;

                prefixSum[i]++;
                prefixSum[i + k]--;

                currSum++;
            }
        }

        return cnt;
    }
}