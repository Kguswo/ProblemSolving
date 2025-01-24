/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static char[][] board;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17302_흰색으로만들기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int k=0; k<4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(isValid(nr, nc)) command2(nr, nc);
                }
            }
        }

        sb.append(1).append("\n");
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 'B') sb.append(3);
                else sb.append(2);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private void command2(int r, int c) {
        if(board[r][c] == 'W') board[r][c] = 'B';
        else board[r][c] = 'W';
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}