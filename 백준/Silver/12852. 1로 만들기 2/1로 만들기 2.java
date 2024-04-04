import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp = new int[N + 1];
		ans = new int[N + 1];
		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			ans[i] = i - 1;
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
				ans[i] = i / 2;
			}
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
				ans[i] = i / 3;
			}
		}
		System.out.println(dp[N]);
		while (true) {
			if (N == 1)
				break;
			System.out.print(N + " ");
			N = ans[N];
		}
		System.out.print(1);
	}
}