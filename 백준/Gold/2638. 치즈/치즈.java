import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, board[][], di[] = { -1, 0, 1, 0 }, dj[] = { 0, 1, 0, -1 }, time;
	static boolean visited[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
//		showboard();

		// visited를 초기화 함.
		// board에서 실내공기를 찾음-> 방문하지 않은 곳이 실내공기임
		// 1을 순회하며 실외공기와 2면이상 접촉시 0으로 만듬
		// 모두 0이 되면 종료.

		while (noCheese()) {
			visited = new boolean[N][M];
			bfs(0, 0);
			meltCheese();
			getChangedBoard();
			time++;
		}
		System.out.println(time);
	}

	private static void getChangedBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] && board[i][j] == 1) board[i][j] = 0;
			}
		}
	}

	private static void meltCheese() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1 && canMelt(i, j)) visited[i][j] = true;
			}
		}
	}

	private static boolean canMelt(int i, int j) { // 방문한 0이 2면 이상 붙어있을 경우
		boolean flag = false;
		int count = 0;
		for (int k = 0; k < 4; k++) {
			int newi = i + di[k];
			int newj = j + dj[k];
			if(board[newi][newj] == 0 && visited[newi][newj]) count++;
		}
		if (count >= 2) flag = true;
		return flag;
	}

	private static void bfs(int starti, int startj) { // 실내공기 찾기!
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { starti, startj });
		visited[starti][startj] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int k = 0; k < 4; k++) {
				int newi = current[0] + di[k];
				int newj = current[1] + dj[k];
				if (isIn(newi, newj) && !visited[newi][newj] && board[newi][newj] == 0) {
					queue.offer(new int[] { newi, newj });
					visited[newi][newj] = true;
				}
			}
		}
	}

	private static boolean isIn(int newi, int newj) {
		return (newi >= 0 && newj >= 0 && newi < N && newj < M);
	}

	private static boolean noCheese() { // 남은 치즈 없으면 false반환
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] != 0) {
					flag = true;
				}
			}
		}
		return flag;
	}

	private static void showboard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
