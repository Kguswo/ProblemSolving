import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int T, N, board[][], ans;
	static int[] di = { 1, 1, -1, -1 };
	static int[] dj = { 1, -1, -1, 1 };
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			board = new int[N][N];
			flag = false;
			ans = 0;
			System.out.print("#" + tc + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			powerset(1);
			if (!flag)
				System.out.println(-1);
			else
				System.out.println(ans);
		}
	}

	private static void powerset(int cnt) {
		int totallength = 0;
		for (int i = 2; i <= N - 1; i++) {
			totallength = i;
			int[] sqlength = new int[2];
			for (int j = 1; j < totallength; j++) {
				sqlength[0] = j; // 오른쪽 아래, 왼쪽 위 갈 횟수
				sqlength[1] = totallength - j; // 왼쪽 아래, 오른쪽 위 갈 횟수
				start(sqlength);
			}

		}
	}

	private static void start(int[] s) {
		for (int i = 0; i < N - (s[0] + s[1]); i++) {
			for (int j = s[1]; j < N - s[0]; j++) {
				sum(s, i, j);
			}
		}
	}

	private static void sum(int[] s, int r, int c) {
		List<Integer> list = new ArrayList<Integer>();

		// 오른아래로
		for (int i = 1; i <= s[0]; i++) {
			if (!list.contains(board[r + di[0] * i][c + dj[0] * i])) {
				list.add(board[r + di[0] * i][c + dj[0] * i]);
			}
		}
		int newi = r + di[0] * s[0];
		int newj = c + dj[0] * s[0];

		// 왼아래로
		for (int i = 1; i <= s[1]; i++) {
			if (!list.contains(board[newi + di[1] * i][newj + dj[1] * i])) {
				list.add(board[newi + di[1] * i][newj + dj[1] * i]);
			}
		}
		newi = newi + di[1] * s[1];
		newj = newj + dj[1] * s[1];

		// 왼위로
		for (int i = 1; i <= s[0]; i++) {
			if (!list.contains(board[newi + di[2] * i][newj + dj[2] * i])) {
				list.add(board[newi + di[2] * i][newj + dj[2] * i]);
			}
		}
		newi = newi + di[2] * s[0];
		newj = newj + dj[2] * s[0];

		// 오른위로
		for (int i = 1; i <= s[1]; i++) {
			if (!list.contains(board[newi + di[3] * i][newj + dj[3] * i])) {
				list.add(board[newi + di[3] * i][newj + dj[3] * i]);

			}
		}

		int sum = 0;
		if (list.size() == 2 * (s[0] + s[1])) {
			flag = true; // 한번이라도 제대로된 케이스 있으면
			for (int a : list) {
				sum += a;
			}
		}
		if (sum != 0) {
			ans = 2 * (s[0] + s[1]);
		}
	}
}
