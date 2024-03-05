import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int T, N, M, K;
	static int[][] board;
	static boolean[][] visited;
	static int count = 0;
	static int countsum = 0;

	static int countbfs;
	static int count2 = 0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			board = new int[N + 2][M + 2];
			visited = new boolean[N + 2][M + 2];
		
			for(int k=0; k<K; k++) {
				int i = sc.nextInt()+1;
				int j = sc.nextInt()+1;
				for (int r = 1; r < N + 1; r++) {
					for (int c = 1; c < M + 1; c++) {
						if(r==i&&c==j) board[i][j] = 1;
					}
				}
			}
			
//			for (int r = 0; r < N + 2; r++) {
//				for (int c = 0; c < M + 2; c++) {
//					System.out.print(board[r][c]);
//				}
//				System.out.println();
//			}
			

			for (int r = 1; r < N + 1; r++) {
				for (int c = 1; c < M + 1; c++) {
					if (!visited[r][c] && board[r][c] == 1) {
						countsum++;
						dfs(r, c);
					}
				}
			}

		System.out.println(countsum);
		countsum = 0;
		}
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int idx = 0; idx <= 3; idx++) {
			int newr = r + dr[idx];
			int newc = c + dc[idx];
			if (board[newr][newc] == 1 && visited[newr][newc] == false) {
				dfs(newr, newc); // 이동하여 다시 진행
			}
		}
	}
}