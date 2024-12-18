/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int H, W, visited[][], start[], end[];
    static int[] p;
    static char board[][];

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_23563_벽타기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        board = new char[H][W];
        visited = new int[H][W];
        p = new int[H * W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                board[i][j] = str.charAt(j);
                visited[i][j] = Integer.MAX_VALUE;
                p[i * W + j] = i * W + j;
                if (board[i][j] == 'S') {
                    start = new int[]{i, j};
                    visited[i][j] = 0;
                }
                if (board[i][j] == 'E') {
                    end = new int[]{i, j};
                }
            }
        }

        for (int i = 1; i < H - 1; i++) {
            for (int j = 1; j < W - 1; j++) {
                if (board[i][j] != '#' && isNextToWall(i, j)) {
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 1 && nr < H - 1 && nc >= 1 && nc < W - 1 && board[nr][nc] != '#' && isNextToWall(nr, nc)) {
                            union(i * W + j, nr * W + nc);
                        }
                    }
                }
            }
        }

        bfs(start);
        System.out.println(visited[end[0]][end[1]]);

        bw.flush();
        bw.close();
        br.close();
    }

    private boolean isNextToWall(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nr < H && nc >= 0 && nc < W && board[nr][nc] == '#') return true;
        }
        return false;
    }

    private void union(int x, int y) {
        p[find(y)] = find(x);
    }

    private int find(int x) {
        if (p[x] != x) return p[x] = find(p[x]);
        return x;
    }

    private void bfs(int[] start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[2];

            if (currTime > visited[curr[0]][curr[1]]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = curr[0] + dr[k];
                int nc = curr[1] + dc[k];

                if (nr <= 0 || nr >= H - 1 || nc <= 0 || nc >= W - 1 || board[nr][nc] == '#') continue;

                int time = currTime + 1;

                if (isNextToWall(curr[0], curr[1]) && isNextToWall(nr, nc) && find(curr[0] * W + curr[1]) == find(nr * W + nc)) {
                    time = currTime;
                }

                if (visited[nr][nc] > time) {
                    visited[nr][nc] = time;
                    pq.offer(new int[]{nr, nc, time});
                }
            }
        }
    }
}