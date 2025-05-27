/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int board[][], dp[][];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1915_가장큰정사각형/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        dp = new int[n][m];
        if(board[0][0] == 1) dp[0][0] = 1;
        for(int i=1; i<n; i++){
            if(board[i][0] == 1) dp[i][0] = 1;
        }
        for(int j=1; j<m; j++){
            if(board[0][j] == 1) dp[0][j] = 1;
        }

        boolean flag = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        if(!flag) {
            System.out.println(0);
            return;
        }

        int max = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
//        for(int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(max * max);

        bw.flush();
        bw.close();
        br.close();
    }
}