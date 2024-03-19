import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, k;
	static int[] coin, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		coin = new int[n];
		dp = new int[k + 1];
		for(int i=0; i<n; i++) 
			coin[i] = sc.nextInt();
		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<dp.length; j++) 
                dp[j] += dp[j-coin[i]];
		}
		System.out.println(dp[k]);
	}
}