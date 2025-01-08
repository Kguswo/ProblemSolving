/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, board[][], dp[][], dr[] = {-1, 1, 0, 0}, dc[] = {0, 0, -1, 1};
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		dp = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				res = Math.max(res, dfs(i, j));
			}
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private int dfs(int r, int c) {
		if(dp[r][c] != 0) return dp[r][c];
		
		dp[r][c] = 1;
		
		for(int k=0; k<4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(board[nr][nc] > board[r][c]) dp[r][c] = Math.max(dp[r][c], dfs(nr, nc) + 1);
			}
		}
		return dp[r][c];
	}
}