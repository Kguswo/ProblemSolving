import java.util.Scanner;

public class Main {
	static int N, M, board[][], dp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				dp[i][j] = board[i][j] + Math.max(Math.max(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
			}
		}
		System.out.println(dp[N][M]);
	}
}