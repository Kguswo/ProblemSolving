class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];

        for(int i=1; i<=len; i++){
            String s = strs[i-1];
            int[] cnt = count(s);
            int zeroCnt = cnt[0];
            int oneCnt = cnt[1];

            // 0-1 냅색
            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++){
                    dp[i][j][k] = dp[i-1][j][k]; // 0-case - default

                    if(j >= zeroCnt && k >= oneCnt) dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-zeroCnt][k-oneCnt] + 1); // 1-case
                }
            }
        }

        return dp[len][m][n];
    }

    private int[] count(String s){
        int[] cnt = new int[2];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0') cnt[0]++;
            else cnt[1]++;
        }
        return cnt;
    }
}