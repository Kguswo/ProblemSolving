/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, Weight[], Energy[];
    static long maxBoard[][], dp[][];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15912_우주선만들기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Weight = new int[N];
        Energy = new int[N];
        dp = new long[N][N];
        maxBoard = new long[N][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Weight[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            Energy[i] = Integer.parseInt(st.nextToken());
        }

        long maxW=0, maxE=0;
        for (int i = 0; i < N; i++) {
            maxW = Weight[i];
            maxE = Energy[i];
            for (int j = i; j < N; j++) {
                maxW = Math.max(maxW, Weight[j]);
                maxE = Math.max(maxE, Energy[j]);
                maxBoard[i][j] = maxW * maxE;
                if(i == j) dp[i][j] = maxBoard[i][j];
            }
        }

        for(int len=2; len<=N; len++) {
            for(int start=0; start<=N-len; start++) {
                int end = start+len-1;
                dp[start][end] = maxBoard[start][end]; // 한번에 구매
                for(int idx=start; idx<end; idx++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][idx] + dp[idx+1][end]); // 분할구매
                }
            }
        }

        bw.write(String.valueOf(dp[0][N-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}