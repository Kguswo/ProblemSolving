/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, w[], totalW, teamACnt[][], gap = Integer.MAX_VALUE, finalA, finalB;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_4384_공평하게팀나누기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        w = new int[N+1];
        for(int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(br.readLine());
            totalW += w[i];
        }

        dp = new boolean[N+1][totalW+1];
        teamACnt = new int[N+1][totalW+1];

        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            for(int j = 0; j <= totalW; j++) {
                if(dp[i-1][j]) {
                    dp[i][j] = true;
                    teamACnt[i][j] = teamACnt[i-1][j];
                }
                if(j-w[i]>=0 && dp[i-1][j-w[i]]) { // 더 균형잡힌 팀 구성도 고려해야함
                    if(Math.abs(N/2 - (teamACnt[i-1][j-w[i]]+1)) < Math.abs(N/2 - teamACnt[i][j])
                    && Math.abs((N-N/2) - (teamACnt[i-1][j-w[i]]+1)) < Math.abs((N-N/2) - teamACnt[i][j])){
                        dp[i][j] = true;
                        teamACnt[i][j] = teamACnt[i-1][j-w[i]] +1;
                    }
                }
            }
        }

        for(int a_w = 1; a_w <= totalW; a_w++) {
            if((teamACnt[N][a_w] == N/2 || teamACnt[N][a_w] == (N - N/2))&& dp[N][a_w]){
                if(Math.abs(a_w - (totalW - a_w)) < gap){
                    finalA = a_w;
                    finalB = totalW - a_w;
                    gap = Math.abs(a_w - (totalW - a_w));
                }
            }
        }
        if(finalA > finalB) {
            int tmp = finalA;
            finalA = finalB;
            finalB = tmp;
        }
        bw.write(String.valueOf(finalA) + " " + finalB);
        bw.flush();
        bw.close();
        br.close();
    }
}