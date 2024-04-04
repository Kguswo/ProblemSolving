import java.util.Scanner;

public class Main {
	static int N, dp[][], board[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		dp = new int[N + 1][3];
		board = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= N; i++) {
			dp[i][0] = board[i - 1][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = board[i - 1][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = board[i - 1][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}