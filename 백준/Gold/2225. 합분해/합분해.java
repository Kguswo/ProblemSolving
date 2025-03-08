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
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2225_합분해/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        for (int j = 1; j <= N; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= K; i++) { // 개수
            dp[i][0] = 1;
            for (int j = 1; j <= N; j++) { // 합
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        System.out.println(dp[K][N]);
    }
}