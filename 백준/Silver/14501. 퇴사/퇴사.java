import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[2][N];
		int[] dp = new int[N+1];
		for(int i=0; i<N; i++) {
			board[0][i] = sc.nextInt();
			board[1][i] = sc.nextInt();
		}
		for(int i=N-1; i>=0; i--) {
			if(i+board[0][i]<=N) dp[i] = Math.max(dp[i+1], dp[i+board[0][i]]+board[1][i]);
			else dp[i] = dp[i+1];
		}
		System.out.println(dp[0]);
	}
}