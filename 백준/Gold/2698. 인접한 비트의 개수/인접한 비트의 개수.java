/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int TC, N, K, dp[][];

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2698_인접한비트의개수/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TC = Integer.parseInt(br.readLine());
        dp = new int[101][101];
        dp[0][0] = 1;
        dp[1][0] = 2;
        for(int i=2;i<=100;i++){
            for(int j=i-1;j>0;j--){
                dp[i][j] = dp[i-1][j] + dp[i-2][j] + (dp[i-1][j-1] - dp[i-2][j-1]);
            }
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
        }
        
        while(TC-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            sb.append(String.valueOf(dp[N][K])).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}