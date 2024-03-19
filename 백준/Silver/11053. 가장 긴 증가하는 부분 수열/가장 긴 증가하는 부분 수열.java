import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, length;
	static int ans = Integer.MIN_VALUE;
	static int[] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
		DP(dp);
	}
	private static void DP(int[] dp) {
		for(int i=1; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]) dp[i] = Math.max(dp[j] + 1, dp[i]); //바로 전 작은값까지 최대길이 + 1로 마무리
			}
		}
		for(int i : dp) ans = Math.max(i, ans);
		System.out.println(ans);
	}
}
