import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int [][] dp = new int[k+1][15];
			for(int j=0; j<15; j++) {
				dp[0][j] = j;
			}
			for(int i=1; i<=k; i++) {
				for(int j=1; j<15; j++) {
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
				}
			}
			System.out.println(dp[k][n]);
		}
	}
}