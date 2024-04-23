import java.util.Scanner;

public class Main {
	static int N, board[][], diri[] = { 0, 1, 0, -1 }, dirj[] = { -1, 0, 1, 0 }, idx, outSand; // 좌 하 우 상
	static int sandI[][] = 
			{{0, -1, 0, 1, -2, -1, 1, 2, -1, 1},
			{2, 1, 1, 1, 0, 0, 0, 0, -1, -1},
			{0, -1, 0, 1, -2, -1, 1, 2, -1, 1},
			{-2, -1, -1, -1, 0, 0, 0, 0, 1, 1}};
	static int sandJ[][] = 
			{{-2, -1, -1, -1, 0, 0, 0, 0, 1, 1},
			{0, -1, 0, 1, -2, -1, 1, 2, -1, 1},
			{2, 1, 1, 1, 0, 0, 0, 0, -1, -1},
			{0, 1, 0, -1, 2, 1, -1, -2, 1, -1}};
	static double sandV[] = { 0.05, 0.1, 0, 0.1, 0.02, 0.07, 0.07, 0.02, 0.01, 0.01 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int firstSum = firstSum();
		int r = N / 2;
		int c = N / 2;

		for (int i = 1; i <= N - 1; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < i; k++) {
					r += diri[idx];
					c += dirj[idx];
//					System.out.println("r : " + r + " c : " + c);
					moveSand(r, c, board[r][c], idx);
					board[r][c] = 0;
				}
				idx = (idx + 1) % 4;// 진행방향 변경
			}
		}
		for (int i = 0; i < N - 1; i++) { // 마지막 왼쪽으로 진행.
			r += diri[0];
			c += dirj[0];
			moveSand(r, c, board[r][c], 0);
			board[r][c] = 0;
		}
		int lastSum = lastSum();
		System.out.println(firstSum - lastSum);

	}

	private static int lastSum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += board[i][j];
			}
		}
		return sum;
	}

	private static int firstSum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += board[i][j];
			}
		}
		return sum;
	}

	private static void moveSand(int i, int j, int y, int idx) {
		int alpha = y;
		for (int k = 0; k < 10; k++) {
			int newi = i + sandI[idx][k];
			int newj = j + sandJ[idx][k];
			alpha -= Math.floor(sandV[k] * y);
			if (isIn(newi, newj)) {
				board[newi][newj] += Math.floor(sandV[k] * y);
			}
		}
		if (isIn(i + sandI[idx][2], j + sandJ[idx][2])) {
			board[i + sandI[idx][2]][j + sandJ[idx][2]] += alpha;
		}
	}

	private static boolean isIn(int newi, int newj) {
		return newi >= 0 && newj >= 0 && newi < N && newj < N;
	}
}