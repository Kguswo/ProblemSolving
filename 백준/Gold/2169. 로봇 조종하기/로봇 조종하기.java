/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, dr[] = {0, 0, 1}, dc[] = {-1, 1, 0};
    static int[][] board, dp;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2169_로봇조종하기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];
        for(int j=1; j < M; j++){
            dp[0][j] = dp[0][j-1] + board[0][j];
        }

        for(int i=1; i<N; i++){
            int[] LtoR = new int[M];
            int[] RtoL = new int[M];

            LtoR[0] = dp[i-1][0] + board[i][0];
            for(int j=1; j<M; j++){
                LtoR[j] = Math.max(dp[i-1][j], LtoR[j-1]) + board[i][j];
            }

            RtoL[M-1] = dp[i-1][M-1] + board[i][M-1];
            for(int j=M-2; j>=0; j--){
                RtoL[j] = Math.max(dp[i-1][j], RtoL[j+1]) + board[i][j];
            }

            for(int j=0; j<M; j++){
                dp[i][j] = Math.max(LtoR[j], RtoL[j]);
            }
        }

        System.out.println(dp[N-1][M-1]);
        br.close();
    }
}