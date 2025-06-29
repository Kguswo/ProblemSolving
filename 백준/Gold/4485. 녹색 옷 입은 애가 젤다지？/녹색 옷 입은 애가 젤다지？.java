/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {

    class Cell implements Comparable<Cell> {
        int r, c, cost;

        public Cell(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cell o) {
            return this.cost - o.cost;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int tc, N;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] board, minDist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_4485_녹색옷입은애가젤다지/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            tc++;
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            else {
                int res = tour();
                makeAns(res);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private int tour() throws IOException {
        board = new int[N][N];
        minDist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.offer(new Cell(0, 0, board[0][0]));
        minDist[0][0] = board[0][0];

        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            if (curr.cost > minDist[curr.r][curr.c]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = curr.r + dr[k];
                int nc = curr.c + dc[k];
                if (isValid(nr, nc) && curr.cost + board[nr][nc] < minDist[nr][nc]) {
                    minDist[nr][nc] = curr.cost + board[nr][nc];
                    pq.offer(new Cell(nr, nc, minDist[nr][nc]));
                }
            }
        }

        return minDist[N - 1][N - 1];
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private void makeAns(int res) {
        sb.append("Problem ").append(tc).append(": ").append(res).append("\n");
    }
}