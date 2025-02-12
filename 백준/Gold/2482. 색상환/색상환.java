/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static int[][] dp;
    static final int MOD = (int)1e9 + 3;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2482_색상환/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        if(K > N/2) {
            System.out.println(0);
            return;
        }
        if(K==1) {
            System.out.println(N);
            return;
        }

        dp = new int[N + 1][N/2 + 1];

        for(int i=1; i<=N; i++){
            dp[i][0] = 1;
            dp[i][1] = i;
        }


        for(int i=2; i<=N; i++){
            for(int j=2; j<=N/2; j++){
                dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % MOD;
            }
        }

        int selectFrom1 = dp[N-3][K-1] % MOD;
        int selectFrom2 = dp[N-1][K] % MOD;
        bw.write(String.valueOf((selectFrom1 + selectFrom2) % MOD));
        bw.flush();
        bw.close();
        br.close();
    }
}