/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] dr = { 0, 0, -1, 1 }, dc = { -1, 1, 0, 0 };
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16931_겉넓이구하기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int S = 2 * N * M;

        for(int i=0; i<N; i++) {
            int[] curr = new int[]{i, 0};
            S += board[i][0];
            for(int j=1; j<M; j++) {
                if(board[i][j] > board[i][j-1]) S += board[i][j] - board[i][j-1];
            }
        }
        for(int i=0; i<N; i++) {
            int[] curr = new int[]{i, 0};
            S += board[i][M-1];
            for(int j=M-2; j>=0; j--) {
                if(board[i][j] > board[i][j+1]) S += board[i][j] - board[i][j+1];
            }
        }
        for(int j=0; j<M; j++) {
            S += board[0][j];
            for(int i=1; i<N; i++) {
                if(board[i][j] > board[i-1][j]) S += board[i][j] - board[i-1][j];
            }
        }
        for(int j=0; j<M; j++) {
            S += board[N-1][j];
            for(int i=N-2; i>=0; i--) {
                if(board[i][j] > board[i+1][j]) S += board[i][j] - board[i+1][j];
            }
        }

        System.out.println(S);
        bw.flush();
        bw.close();
        br.close();
    }
}