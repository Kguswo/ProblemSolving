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
    static int N, M, board[][], cnt;
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_10159_저울/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            board[u][v] = -1;
            board[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            cnt = 0;
            // 오름차순
            visited = new boolean[N + 1];
            dfs(i, i, -1);

            // 내림차순
            visited = new boolean[N + 1];
            dfs(i, i, 1);

            sb.append(N - (cnt + 1)).append("\n");
        }

        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int start, int curr, int dir) { // dir -1이면 더 큰수찾기, 1이면 더 작은수찾기
        visited[start] = true;

        for (int next = 1; next <= N; next++) {
            if (!visited[next] && board[curr][next] == dir) {
                cnt++;
                visited[next] = true;
                dfs(start, next, dir);
            }
        }
    }
}