import java.util.*;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum += cardPoints[i];
        }

        if(k >=n) return sum;

        int[] LtoR_PrefixSum = new int[n];
        int[] RtoL_PrefixSum = new int[n];

        LtoR_PrefixSum[0] = cardPoints[0];
        for(int i=1; i<n; i++){
            LtoR_PrefixSum[i] = LtoR_PrefixSum[i-1] + cardPoints[i];
        }

        RtoL_PrefixSum[n-1] = cardPoints[n-1];
        for(int i=n-2; i>=0; i--){
            RtoL_PrefixSum[i] = RtoL_PrefixSum[i+1] + cardPoints[i];
        }

        System.out.println(Arrays.toString(LtoR_PrefixSum));
        System.out.println(Arrays.toString(RtoL_PrefixSum));

        int left = k-1;
        int right = n;

        int res = Math.max(LtoR_PrefixSum[k-1], RtoL_PrefixSum[n-k]);
        for(int i = 1; i<= k-1; i++){
            res = Math.max(res, LtoR_PrefixSum[left - i] + RtoL_PrefixSum[right - i]);
        }
        return res;
    }
}