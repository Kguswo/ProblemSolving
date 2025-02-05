/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, res;
    static int[] dc = {-1, 0, 1};
    static char[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_3109_빵집/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            if(dfs(i, 0)) res++;
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean dfs(int r, int c) {
        board[r][c] = 'p';

        if(c == M-1) return true;

        for(int k=0; k<3; k++){
            int nr = r+dc[k];
            int nc = c+1;

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

            if(board[nr][nc] == '.') {
                if(dfs(nr, nc)) return true;
            }
        }
        return false;
    }
}
