/**
 * Author : nowalex322, Kim Hyeonjae
 */

import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N, tmp, ans;
    public static int[][] board;
    public static int[] dr = {-1, 1, 1, -1};
    public static int[] dc = {1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
//    	br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	N = Integer.parseInt(br.readLine());
    	board = new int[N][N];
    	
    	for (int i = 0; i < N; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < N; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	//첫째칸부터(흰칸) DFS
        dfs(0, 0);
        ans += tmp;
        
        tmp = 0;
        //두번째칸부터(흑칸) DFS
        dfs(1, 0);
        ans += tmp;
        
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPuttable(int i, int j) {
        for (int k = 0; k < 4; k++) {
        	// 대각선으로 늘어날 길이 n
            int n = 1;
            while(true) {
                int r = i + n * dr[k];
                int c = j + n * dc[k];
                // 경계조건 밖일때
                if (r < 0 || c < 0 || r >= N || c >= N) break;
                    
                // 비숍 놓아져 있는경우
                if (board[r][c] == 2) return false;
                n++;
            }
        }
        return true;
    }

    /**
     * 이동할 칸 계산
     * 판 길이 홀수x홀수면 2씩증가, 짝수면 흑백 계산해서 증가
     * @param i
     * @return
     */
    public static int calNext(int i) {
        //크기가 홀 수일 경우 -> 2증가
        if (N % 2 == 1) return 2;
        
        //크기가 짝수일 경우
        if (i % N == N-1) return 1;
        else if (i % N == N-2) return 3;
        else return 2;
    }

    public static void dfs(int i, int cnt) {
        if (i >= N*N) {
            tmp = Math.max(tmp, cnt);
            return;
        }
        int c = i % N;
        int r = i / N;
        int next = calNext(i);

        // 둘 수 없는 곳일 경우
        if (board[r][c] == 0) {
            dfs(i + next, cnt);
            return;
        }

        // 둘 수 있는 곳일 경우
        if (isPuttable(r, c)) {
            board[r][c] = 2;
            dfs(i+next, cnt+1);
            board[r][c] = 1;
        }
        // 그냥 안두는 케이스
        dfs(i+next, cnt);
    }

}