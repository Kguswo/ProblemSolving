import java.util.*;
import java.lang.Math;

class Solution {
    int[][] dp;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature+=10; t1+=10; t2+=10;
        int answer = Integer.MAX_VALUE;
        dp = new int[onboard.length][51];
        for(int i=0; i<onboard.length; i++){
            for(int j=0; j<51; j++){
                dp[i][j] = 2000000;
            }
        }
        dp[0][temperature] = 0;

        if(t1<=temperature && temperature<=t2) return 0;
        
        for (int i=0; i<onboard.length-1; i++) {
            for (int j=0; j<=50; j++) {
            	
                // 승객이 탑승했는데 온도 범위 밖인 경우 SKIP
                if(onboard[i]==1 && (j<t1 || j>t2)) continue;
                
                //전력x
                int T = j;
                // 외부온도 > 현재온도
                if(j>temperature && j>0) T = j-1;
                // 외부온도 < 현재온도
                else if(j<temperature && j<50) T = j+1;
                dp[i+1][T] = Math.min(dp[i][j], dp[i+1][T]);

                // 2. 희망온도!=현재온도
                if(j>0) dp[i+1][j-1] = Math.min(dp[i][j]+a, dp[i+1][j-1]);
                if(j<50) dp[i+1][j+1] = Math.min(dp[i][j]+a, dp[i+1][j+1]);

                // 3. 희망온도==현재온도
                dp[i+1][j] = Math.min(dp[i][j]+b, dp[i+1][j]);
            }
        }

        for (int j=0; j<=50; j++) {
            if(onboard[onboard.length-1]==1 && (j<t1 || j>t2)) continue;
            answer = Math.min(dp[onboard.length-1][j], answer);
        }

        return answer;
    }
}