/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N;
	static int[] dr = {1, 0, -1, 0}, dc = {0, -1, 0, 1};
	static char[][] board;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		String res = dfs(0) ? "YES" : "NO";
		bw.write(res);
		bw.flush();
		bw.close();
		br.close();
	}
	
	private boolean dfs(int trap) {
		if(trap == 3) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j] == 'T' && checkS(i, j)) return false;
				}
			}
			return true;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] == 'X') {
					board[i][j] = 'O';
					if(dfs(trap + 1)) return true;
					board[i][j] = 'X';
				}
			}
		}
		return false;
	}

	private static boolean checkS(int r, int c) {
		for(int k=0; k<4; k++) {
			int nr = r;
			int nc = c;
			while(true) {
				nr += dr[k];
				nc += dc[k];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) break;
				if(board[nr][nc] == 'O') break;
				if(board[nr][nc] == 'S') return true;
			}
		}
		return false;
	}
}