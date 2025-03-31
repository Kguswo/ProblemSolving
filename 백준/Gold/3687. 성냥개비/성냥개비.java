/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int[] nums = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6}; // 0~9 성냥개수
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_3687_성냥개비/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] dp = new long[101]; // min계산
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;
        dp[9] = 18;
        dp[10] = 22;

        // DP 계산 - 최소값 구하기
        for (int i = 11; i <= 100; i++) {
            for (int num = 0; num < 10; num++) {
                if (i - nums[num] >= 2 && dp[i - nums[num]] != Long.MAX_VALUE) { // 자릿수추가
                    // 0
                    if(num == 0) dp[i] = Math.min(dp[i], dp[i-nums[num]] * 10L);

                    else{
                        long tmp1 = dp[i - nums[num]] * 10L + num;
                        long tmp2 = num * (long) Math.pow(10, digitCnt(dp[i-nums[num]])) + dp[i-nums[num]];

                        dp[i] = Math.min(dp[i], Math.min(tmp1, tmp2));
                    }
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            //min
            sb.append(dp[n]).append(" ");

            //max
            if(n%2 == 1){
                sb.append(7);
                for(int i=0; i<(n-3)/2; i++){
                    sb.append(1);
                }
            }
            else{
                for(int i=0; i<n/2; i++){
                    sb.append(1);
                }
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private int digitCnt(long num){
        if(num==0) return 1;
        return (int) Math.log10(num) + 1;
    }
}