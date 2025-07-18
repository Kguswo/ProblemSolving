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
    static int[][] board;
    static int[][] res;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/제9회천하제일코딩대회본선OpenContest/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if((N*M)%2 == 1) {
            System.out.println("No");
            return;
        }

        board = new int[N][M];
        res = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt1 = 0, cnt2 = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if((i+j)%2 == 0) cnt1++;
                else cnt2++;
            }
        }

        if(cnt1 != cnt2) {
            System.out.println("No");
            return;
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, res[i], 0, M);
        }

        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    for(int k=0; k<4; k++){
                        int nr = i+dr[k];
                        int nc = j+dc[k];
                        if(isValid(nr, nc) && !visited[nr][nc]){
                            visited[i][j] = true;
                            visited[nr][nc] = true;

                            int tmp = res[i][j];
                            res[i][j] = res[nr][nc];
                            res[nr][nc] = tmp;
                            break;
                        }
                    }
                }
            }
        }
        
        System.out.println("Yes");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(res[i][j]);
                if (j < M - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}