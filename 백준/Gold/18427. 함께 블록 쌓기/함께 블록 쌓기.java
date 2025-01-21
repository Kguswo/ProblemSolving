/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static final int MOD = 10007;
    static int N, M, H, dp[][];
    static ArrayList<Integer>[] block;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_18427_함께블록쌓기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        block = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            block[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                block[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dp = new int[N + 1][H+1];
        dp[1][0] = 1;
        for(int b : block[1]){
            if(b <= H) dp[1][b] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<=H; j++){
                // i번째 안 쌓으면
                dp[i][j] = dp[i-1][j];

                // i번째에 쌓으면
                for(int b : block[i]){
                     // 이번에 j높이까지 쌓기위해 height를 쌓는데 이 값이 쌓기전에 높이가 음수면 말이 안됨. 쌓기전 값 최소 0 (인덱스 문제도 해결)
                    if(j-b>=0) dp[i][j] = (dp[i][j] + dp[i-1][j-b]) % MOD; // 이전것도 고려해서 더해줌
                }
            }
        }

        bw.write(String.valueOf(dp[N][H]));
        bw.flush();
        bw.close();
        br.close();
    }
}