class Solution {
    public int solution(int[][] triangle) {
        int res = 0;
        // 총 개수 = 높이 x (높이+1) / 2
        int h = triangle.length;
        int n = h * (h + 1) / 2;
        int[] dp = new int[n+1];
        
        // 마지막에 체크할 인덱스 : (n-h)+1 ~ n
        
        //  4 5 6    층 3
        // 7 8 9 10  층 4
        
        dp[1] = triangle[0][0];
        int curr = 1; // 지금인덱스
        for(int i=0; i<h-1; i++){
            for(int j=0; j<triangle[i].length; j++){
                int val = dp[curr];
                
                dp[curr + (i+1)] = Math.max(dp[curr + (i+1)], val + triangle[i+1][j]);
                
                dp[curr + (i+1) + 1] = Math.max(dp[curr + (i+1) + 1], val + triangle[i+1][j+1]);
                
                curr++;
            }
        }
        
        for(int i=n-h+1; i<=n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}