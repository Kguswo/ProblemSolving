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
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    class Node implements Comparable<Node> {
        int r, c, breakCnt;
        public Node(int r, int c, int breakCnt){
            this.r = r;
            this.c = c;
            this.breakCnt = breakCnt;
        }

        public int compareTo(Node o) {
            return this.breakCnt - o.breakCnt;
        }
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1261_알고스팟/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        int[][] board = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = line.charAt(j) - '0';
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][M];
        pq.add(new Node(0, 0, 0));
        visited[0][0] = true;

        int res = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(curr.r == N-1 && curr.c == M-1) {
                res = curr.breakCnt;
                System.out.println(res);
                return;
            }

            for(int k=0; k < 4; k++){
                int nr = curr.r + dr[k];
                int nc = curr.c + dc[k];
                if(isValid(nr, nc) && !visited[nr][nc]){
                    if(board[nr][nc] == 0){
                        pq.add(new Node(nr, nc, curr.breakCnt));
                    }
                    else{
                        pq.add(new Node(nr, nc, curr.breakCnt + 1));
                    }
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private boolean isValid(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}