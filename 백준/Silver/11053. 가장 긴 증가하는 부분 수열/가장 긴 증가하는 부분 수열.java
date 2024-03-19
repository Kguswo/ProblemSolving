import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, length;
	static int ans = Integer.MIN_VALUE;
	static int[] arr, dp;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		N=sc.nextInt();
		arr = new int[N+1];
		dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
			dp[i] = 1;
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		DP(dp);
		
	}
	private static void DP(int[] dp) {
		for(int i=2; i<=N; i++) {
			for(int j=1; j<=i-1; j++) {
				if(arr[i]>arr[i-j]) dp[i] = Math.max(dp[i-j] + 1, dp[i]); //바로 전 작은값까지 최대길이 + 1로 마무리
			}
		}
		for(int i : dp) ans = Math.max(i, ans);
		System.out.println(ans);
	}
}
