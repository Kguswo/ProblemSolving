/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Node implements Comparable<Node>{
        int r, c, breakCnt;
        public Node(int r, int c, int breakCnt) {
            this.r = r;
            this.c = c;
            this.breakCnt = breakCnt;
        }

        @Override
        public int compareTo(Node o){
            return this.breakCnt - o.breakCnt;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, board[][], dr[] = {-1, 1, 0, 0}, dc[] = {0, 0 ,-1, 1};
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1261_알고스팟/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];

        // padding with -1
        for(int i = 0; i <= M+1; i++) {
            board[0][i] = -1;
            board[N+1][i] = -1;
        }
        for(int i = 0; i <= N+1; i++) {
            board[i][0] = -1;
            board[i][M+1] = -1;
        }

        for(int i = 1; i < N+1; i++){
            String line = br.readLine();
            for(int j = 1; j < M+1; j++){
                board[i][j] = line.charAt(j-1) - '0';
            }
        }
        
        int res = bfs(1, 1);
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int r, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(r, c, 0));
        visited[r][c] = true;

        while(!pq.isEmpty()){
            Node currNode = pq.poll();

            if(currNode.r == N && currNode.c == M) return currNode.breakCnt;

            for(int k=0; k<4; k++){
                int nextR = currNode.r + dr[k];
                int nextC = currNode.c + dc[k];
                int currBreakCnt = currNode.breakCnt;

                if(board[nextR][nextC] == -1) continue;

                if(!visited[nextR][nextC] && board[nextR][nextC] == 0){
                    pq.offer(new Node(nextR, nextC, currBreakCnt));
                    visited[nextR][nextC] = true;
                }

                if(!visited[nextR][nextC] && board[nextR][nextC] == 1){
                    pq.offer(new Node(nextR, nextC, currBreakCnt+1));
                    visited[nextR][nextC] = true;
                }
            }
        }
        return 0;
    }
}