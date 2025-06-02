/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] music;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        music = new int[N+1];
        dp = new long[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            music[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                dp[i][j] = 2_000_000_000;
            }
        }

        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 0;
        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][0] + Math.abs(music[i] - music[i-1]);
            dp[0][i] = dp[0][i-1] + Math.abs(music[i] - music[i-1]);
        }

        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= N; j++){

                if(i==j) continue;

                if((Math.max(i, j) + 1) > N) continue;

                if(i==0 || j == 0) {
                    music[0] = music[Math.max(i, j) + 1];
                    dp[Math.max(i, j) + 1][j] = Math.min(dp[Math.max(i, j) + 1][j], dp[i][j] + Math.abs(music[Math.max(i, j) + 1] - music[i]));
                    dp[i][Math.max(i, j) + 1] = Math.min(dp[i][Math.max(i, j) + 1], dp[i][j] + Math.abs(music[Math.max(i, j) + 1] - music[j]));
                }
                else {
                    dp[Math.max(i, j) + 1][j] = Math.min(dp[Math.max(i, j) + 1][j], dp[i][j] + Math.abs(music[Math.max(i, j) + 1] - music[i]));
                    dp[i][Math.max(i, j) + 1] = Math.min(dp[i][Math.max(i, j) + 1], dp[i][j] + Math.abs(music[Math.max(i, j) + 1] - music[j]));
                }
            }
        }

        long res = 2_000_000_000;
        for(int i = 0; i < N; i++){  // i < N (N 포함 안함)
            res = Math.min(res, dp[i][N]);  // 한명 N번째 곡까지
            res = Math.min(res, dp[N][i]);  // 다른 한명 N번째 곡까지
        }

        System.out.println(res);

//        for(int i=0; i<=N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        br.close();
    }
}