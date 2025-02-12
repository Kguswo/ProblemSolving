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
    static int[] dp;
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

        dp = new int[K + 1];

        for(int i=0; i<=K; i++){
            dp[i] = 1;
        }

        for(int len = 1; len <= N-2*K+1; len++) {
            for(int j=1; j<=K; j++) {
                dp[j] = (dp[j] + dp[j-1]) % MOD;
            }
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println((dp[K] - dp[K-2] + MOD)%MOD);
        bw.flush();
        bw.close();
        br.close();
    }
}