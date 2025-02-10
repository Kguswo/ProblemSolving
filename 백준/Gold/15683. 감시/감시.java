/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int r,c,type;
        public Node(int r,int c,int type){
            this.r=r;
            this.c=c;
            this.type=type;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, res = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][] board;
    static List<Node> cctv = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15683_감시/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= board[i][j] && board[i][j] <= 5 ) {
                    cctv.add(new Node(i, j, board[i][j]));
                }
            }
        }

        cctvComb(0, board);
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void cctvComb(int depth, int[][] currBoard) {
        if(depth == cctv.size()) {
            res = Math.min(res, count(currBoard));
            return;
        }

        Node currCCTV = cctv.get(depth);
        int[][] newBoard = new int[N][M];

        if(currCCTV.type == 1) {
            for(int k=0; k<4; k++){
                copyCurrBoard(currBoard, newBoard);
                changeCurrBoard(currCCTV, newBoard, k);
                cctvComb(depth+1, newBoard);
            }
        }
        else if(currCCTV.type == 2) {
            for(int k=0; k<2; k++){
                copyCurrBoard(currBoard, newBoard);
                changeCurrBoard(currCCTV, newBoard, k);
                changeCurrBoard(currCCTV, newBoard, k+2);
                cctvComb(depth+1, newBoard);
            }
        }
        else if(currCCTV.type == 3) {
            for(int k=0; k<4; k++){
                copyCurrBoard(currBoard, newBoard);
                changeCurrBoard(currCCTV, newBoard, k);
                changeCurrBoard(currCCTV, newBoard, (k+1)%4);
                cctvComb(depth+1, newBoard);
            }
        }
        else if(currCCTV.type == 4) {
            for(int k=0; k<4; k++){
                copyCurrBoard(currBoard, newBoard);
                changeCurrBoard(currCCTV, newBoard, k);
                changeCurrBoard(currCCTV, newBoard, (k+1)%4);
                changeCurrBoard(currCCTV, newBoard, (k+2)%4);
                cctvComb(depth+1, newBoard);
            }
        }
        else if(currCCTV.type == 5) {
            copyCurrBoard(currBoard, newBoard);
            for(int k=0; k<4; k++){
                changeCurrBoard(currCCTV, newBoard, k);
            }
            cctvComb(depth+1, newBoard);
        }
    }

    private static void changeCurrBoard(Node curr, int[][] currBoard, int k) { // cctv가 보는 한 방향 보기
        int nr = curr.r, nc = curr.c;
        while(true){
            nr += dr[k];
            nc += dc[k];
            if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;
            if(currBoard[nr][nc] == 6) break;
            if(currBoard[nr][nc] == 0) currBoard[nr][nc] = -1;
        }
    }

    private static void copyCurrBoard(int[][] currBoard, int[][] newBoard) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                newBoard[i][j] = currBoard[i][j];
            }
        }
    }

    private static int count(int[][] currBoard) {
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(currBoard[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}