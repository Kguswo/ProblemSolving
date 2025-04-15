/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Node implements Comparable<Node>{
        int r, c, h;
        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

        public int compareTo(Node o) {
            return this.h - o.h;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1520_내리막길/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int[][] dp = new int[N][M];
        dp[N-1][M-1] = 1;

        PriorityQueue<Node> nodes = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                nodes.add(new Node(i, j, num));
            }
        }

        while(!nodes.isEmpty()) {
            Node curr = nodes.poll();

            for(int k=0; k<4; k++) {
                int nr = curr.r + dr[k];
                int nc = curr.c + dc[k];
                if(isValid(nr, nc)){
                    if(isLow(curr.h, board[nr][nc])){

                        dp[nr][nc] += dp[curr.r][curr.c];
                    }
                }
            }
        }

        System.out.println(dp[0][0]);
        br.close();
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static boolean isLow(int curr, int next){
        return curr < next;
    }
}