/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {

    class Node implements Comparable<Node> {
        int r;
        int c;
        int jump;

        public Node(int r, int c, int jump) {
            this.r = r;
            this.c = c;
            this.jump = jump;
        }

        @Override
        public int compareTo(Node o) {
            return this.jump - o.jump;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, startR, startC, endR, endC, res;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_14497_주난의난/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        endR = Integer.parseInt(st.nextToken());
        endC = Integer.parseInt(st.nextToken());

        board = new char[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = str.charAt(j - 1);
            }
        }

        bfs();

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private void bfs() {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.jump - o2.jump);
        visited = new boolean[N + 1][M + 1];
        queue.add(new Node(startR, startC, 0));
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int currJump = curr.jump;
            for (int k = 0; k < 4; k++) {
                int nr = curr.r + dr[k];
                int nc = curr.c + dc[k];
                if (nr < 1 || nc < 1 || nr > N || nc > M || visited[nr][nc]) continue;

                if (board[nr][nc] == '#') {
                    res = currJump + 1;
                    return;
                } else if (board[nr][nc] == '0') {
                    queue.add(new Node(nr, nc, currJump));
                    visited[nr][nc] = true;
                } else if (board[nr][nc] == '1') {
                    queue.add(new Node(nr, nc, currJump + 1));
                    visited[nr][nc] = true;
                }
            }

        }
    }
}