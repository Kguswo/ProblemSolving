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
    static int[] marble = new int[3];
    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2600_구슬게임/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) {
            marble[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(marble);
        dp = new boolean[501][501]; // A입장에서 false패배 true승리

        dp[0][0] = false;
        for(int i=0; i<501; i++) {
            for(int j=0; j<501; j++) {
                if(i < marble[0] && j < marble[0]){
                    dp[i][j] = false;
                    continue;
                }
                boolean canwin = false;

                // 왼쪽주머니 선택
                for(int k=0; k<3 && !canwin; k++){
                    if(i >= marble[k] && !dp[i-marble[k]][j]) canwin = true;
                }

                // 오른쪽주머니 선택
                for(int k=0; k<3 && !canwin; k++){
                    if(j >= marble[k] && !dp[i][j-marble[k]]) canwin = true;
                }

                dp[i][j] = canwin;
            }
        }

        for(int q=0; q<5; q++){
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());
            sb.append(dp[k1][k2] ? "A" : "B").append("\n");
        }
        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }
}
