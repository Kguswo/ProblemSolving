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
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17435_합성함수와쿼리/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[19][m+1]; // 2^18 > 500000 이므로 19도 충분함

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            dp[0][i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<19; i++) {
            for(int j=1; j<=m; j++){
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        int q = Integer.parseInt(br.readLine());
        while(q--> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for(int i=0; i<19; i++){
                if((n & (1<<i)) != 0) x = dp[i][x];
            }
            sb.append(x).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}