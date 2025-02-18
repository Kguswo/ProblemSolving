/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, dp[][][], res = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17485_진우의달여행Large/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N+1][M+1][3];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                for(int k=0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }


        for(int i=1; i<=N; i++) {
            if(i==1){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++){
                    int num = Integer.parseInt(st.nextToken());
                    for(int k=0; k<3; k++) {
                        dp[i][j][k] = num;
                    }
                }
            }
            else{
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    // 밑으로 |
                    dp[i][j][0] = Math.min(dp[i-1][j][1], dp[i-1][j][2]) + num;
                    // 왼오\방향
                    if(j>=2) dp[i][j][1] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][2]) + num;
                    // 오왼/ 방향
                    if(j<M) dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + num;
                }
            }
        }

        for(int j=1; j<=M; j++) {
            for(int k=0; k<3; k++) {
                res = Math.min(res, dp[N][j][k]);
            }
        }
        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }
}