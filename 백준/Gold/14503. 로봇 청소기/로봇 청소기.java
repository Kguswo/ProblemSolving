import java.util.Scanner;

public class Main {
	static int N, M, count;
	static int[] di = { -1, 0, 1, 0 }, dj = { 0, 1, 0, -1 };
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];
		int r = sc.nextInt() + 1;
		int c = sc.nextInt() + 1;
		int k = sc.nextInt(); // 방향

		for (int i = 0; i <= N + 1; i++) {
			for (int j = 0; j <= M + 1; j++) {
				board[i][j] = -1;
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				board[i][j] = sc.nextInt();
			}
		}

//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 1; j < M + 1; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}

		dfs(r, c, k);
		System.out.println(count);

//		for (int i = 1; i < N + 1; i++) {
//			for (int j = 1; j < M + 1; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	/*
	 * 작동방법 시작할때 방향 정해짐
	 * 
	 * 현재칸 청소 or 패스 주변 4칸 쳌, 전부 청소됐으면 방향그대로 뒤로 후진 근데 뒤에 칸이 1이라 후진 못하면 stop 전부 청소
	 * 안됐으면 반시계 90도 돌고 갈 칸이 청소되지 않았으면 이동.
	 */
	private static void dfs(int r, int c, int dir) {
//		System.out.println("좌표 : ( " + (r-1) + " , " + (c-1) + " )" + " 방향 : " + dir + " 청소개수 : " + (count));

		// 기저조건
		if (!visited[r][c] && board[r][c] == 0) {
			visited[r][c] = true;
			count++;
		}
		boolean dirty = false;

		for (int i = 0; i < 4; i++) {
//			System.out.println("회전");
			dir = (dir + 3) % 4; // 반시계 90도방향
			int newi = r + di[dir];
			int newj = c + dj[dir];
			if ((board[newi][newj] != -1) && (board[newi][newj] == 0 && !visited[newi][newj])) {
//				System.out.println("이동할 곳 값 : " + board[newi][newj]);
//				System.out.println("             바뀐방향 : " + dir);
				dfs(newi, newj, dir);
				dirty = true;
				return;
			}
		}
		if (!dirty) {
			int backi = r - di[dir];
			int backj = c - dj[dir];
			if (board[backi][backj] != -1 && board[backi][backj] != 1) {
				dfs(backi, backj, dir);
			}
		}
	}
}
