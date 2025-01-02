/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, weight[], arr[];
    static boolean[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2629_양팔저울/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        dp = new boolean[31][500 * 30 + 1]; // 추 30개 , 각 500g이하 -> 무게 1~15000
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > 15000) sb.append("N").append(" ");
            else {
                boolean flag = false;
                for (int j = 0; j <= N; j++) {
                    if (dp[j][arr[i]]) {
                        flag = true;
                        break;
                    }
                }
                sb.append(dp[N][arr[i]] ? "Y" : "N").append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int idx, int sum) {

        if (idx > N || sum > 15000 || dp[idx][sum]) return;

        dp[idx][sum] = true;

        if (idx == N) return;

        dfs(idx + 1, Math.abs(sum - weight[idx]));
        dfs(idx + 1, sum);
        if (sum + weight[idx] <= 15000) dfs(idx + 1, sum + weight[idx]);

    }
}