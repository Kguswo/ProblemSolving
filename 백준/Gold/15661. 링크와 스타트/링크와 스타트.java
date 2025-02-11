/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, board[][], res = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15661_링크와스타트/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int depth, int idx) {
        if(depth >= 1) {
            calAbility();
        }

        for(int i=idx; i<N; i++) {
            if(depth == N-1) continue;
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    private void calAbility() {
        int diff=0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(visited[i] && visited[j]) diff += (board[i][j] + board[j][i]);
                else if(!visited[i] && !visited[j]) diff -= (board[i][j] + board[j][i]);
            }
        }
        res = Math.min(Math.abs(diff), res);
    }
}