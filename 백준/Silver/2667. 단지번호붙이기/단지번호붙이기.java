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
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int count=0;
	static int countsum=0;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

		N = sc.nextInt();
		board = new int[N + 2][N + 2];
		visited = new boolean[N + 2][N + 2];
		List<Integer> list = new ArrayList<>(); // count저장

		for (int r = 1; r < N + 1; r++) {
			String str = sc.next();
			for (int c = 1; c < N + 1; c++) {
				board[r][c] = str.charAt(c - 1) - '0'; // 내부 값을 입력받음
			}
		}

//		for(int r=0; r<N+2; r++) {
//			for(int c=0; c<M+2; c++) {
//				System.out.print(board[r][c]);
//			}
//			System.out.println();
//		}
		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < N + 1; c++) {
				if(!visited[r][c] && board[r][c] == 1 ) {
					countsum++;
					count = 0;
					dfs(r, c);
					list.add(count);
				}
			}
		}
		System.out.println(countsum);
		Collections.sort(list);
		for(int i : list) System.out.println(i);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		count++;
		for (int idx = 0; idx <= 3; idx++) {
			int newr = r + dr[idx];
			int newc = c + dc[idx];
			if (board[newr][newc] == 1 && visited[newr][newc] == false) {
				dfs(newr, newc); // 이동하여 다시 진행
			}
		}
//		visited[r][c] = false;
	}
}