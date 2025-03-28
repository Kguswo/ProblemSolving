/**
 * Author: nowalex322, Kim HyeonJae
 * 15:14 ~ 15:40 (26min)
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1719_택배/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n + 1][n + 1]; // 경로길이(최소)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) board[i][j] = 0;
                else board[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] res = new int[n + 1][n + 1]; // 다음정점 최신화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) res[i][j] = -1;
                else res[i][j] = j;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            board[u][v] = w;
            board[v][u] = w;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (board[i][k] != Integer.MAX_VALUE && board[k][j] != Integer.MAX_VALUE) {
                        if (board[i][j] > board[i][k] + board[k][j]) {
                            board[i][j] = board[i][k] + board[k][j];
                            res[i][j] = res[i][k];
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) sb.append("- ");
                else sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}