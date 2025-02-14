import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] cnt = new int[n+1];
        
        cnt[0] = 1;
        cnt[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<=i-1; j++){
                cnt[i] += cnt[j] * cnt[i-j-1];
            }
        }
        System.out.print(Arrays.toString(cnt));
        return cnt[n];
    }
}