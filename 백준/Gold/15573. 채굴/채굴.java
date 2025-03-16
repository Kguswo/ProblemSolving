/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, K;
    static int [] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15573_채굴/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        int maxD = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] > maxD) maxD = board[i][j];
            }
        }

        int left = 1, right = maxD;
        int res = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;

            int count = countMines(mid);

            if(count >= K){
                res = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }

        System.out.println(res);
        br.close();
    }

    private int countMines(int mid) {
        visited = new boolean[N][M];
        int cnt = 0;

        for (int j = 0; j < M; j++) {
            if (!visited[0][j] && board[0][j] <= mid) {
                cnt += bfs(0, j, mid);
            }
        }

        for (int i=1; i<N; i++) {
            if(!visited[i][0] && board[i][0] <= mid) cnt += bfs(i, 0, mid);
        }

        for (int i=1; i<N; i++) {
            if(!visited[i][M-1] && board[i][M-1] <= mid) cnt += bfs(i, M-1, mid);
        }

        return cnt;
    }

    private static int bfs(int r, int c, int D){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        int cnt = 1;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for (int k=0; k < 4; k++){
                int nextR = curr[0] + dr[k];
                int nextC = curr[1] + dc[k];

                if(isValid(nextR, nextC) && !visited[nextR][nextC]){
                    if(board[nextR][nextC] <= D){
                        queue.offer(new int[]{nextR, nextC});
                        visited[nextR][nextC] = true;
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    private static boolean isValid(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}