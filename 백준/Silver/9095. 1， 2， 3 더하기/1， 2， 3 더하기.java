import java.util.Scanner;

public class Main {
	static int T, N;
	static int [][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 0; tc<T; tc++) {
			N = sc.nextInt();
			dp = new int [3][N+1];
			for(int i=0; i<=N; i++) {
				dp[0][i] = 1;
			}
			dp[1][0] = 1;
			dp[1][1] = dp[0][1];
			for(int i=2; i<=N; i++) {
				dp[1][i] = dp[1][i-2] + dp[1][i-1];
			}
			dp[2][0] = 1;
			dp[2][1] = 1;
			if(N>=2) dp[2][2] = 2;
			for(int i=3; i<=N; i++) {
				dp[2][i] = dp[2][i-3] + dp[2][i-2] + dp[2][i-1];
			}
			System.out.println(dp[2][N]);
		}
	}
}