/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, board[][], maxdp[][], mindp[][];

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2096_내려가기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxdp = new int[N + 1][3];
        mindp = new int[N + 1][3];
        maxdp[1][0] = mindp[1][0] = board[0][0];
        maxdp[1][1] = mindp[1][1] = board[0][1];
        maxdp[1][2] = mindp[1][2] = board[0][2];

        for (int i = 2; i <= N; i++) {
            maxdp[i][0] = board[i - 1][0] + Math.max(maxdp[i - 1][0], maxdp[i - 1][1]);
            mindp[i][0] = board[i - 1][0] + Math.min(mindp[i - 1][0], mindp[i - 1][1]);
            maxdp[i][1] = board[i - 1][1] + Math.max(maxdp[i - 1][0], Math.max(maxdp[i - 1][1], maxdp[i - 1][2]));
            mindp[i][1] = board[i - 1][1] + Math.min(mindp[i - 1][0], Math.min(mindp[i - 1][1], mindp[i - 1][2]));
            maxdp[i][2] = board[i - 1][2] + Math.max(maxdp[i - 1][1], maxdp[i - 1][2]);
            mindp[i][2] = board[i - 1][2] + Math.min(mindp[i - 1][1], mindp[i - 1][2]);
        }

        int maxRes = Math.max(maxdp[N][0], Math.max(maxdp[N][1], maxdp[N][2]));
        int minRes = Math.min(mindp[N][0], Math.min(mindp[N][1], mindp[N][2]));
        StringBuilder sb = new StringBuilder();
        sb.append(maxRes).append(" ").append(minRes);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}