
/**
 * Author : nowalex322, Kim Hyeonjae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static final long MOD = (long) 1e9;

	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		/**
		 * dp에 필요한 저장값 : 끝 숫자, 길이, 방문처리 비트마스킹
		 */
		int dp[][][] = new int[10][len + 1][1 << 10];

		for (int i = 0; i <= 9; i++) {
			dp[i][1][1 << i] = 1;
		}

		// 우선순위 : 숫자 길이 -> 숫자 -> 방문처리 체크		
		for (int j = 2; j <= len; j++) {
			for (int i = 0; i <= 9; i++) {
				for (int k = 0; k < (1 << 10); k++) {
					int visited = k | (1 << i);
					
					if (i == 0) dp[i][j][visited] += dp[1][j - 1][k] % MOD;
					else if (i == 9) dp[i][j][visited] += dp[8][j - 1][k] % MOD;
					else dp[i][j][visited] += (dp[i - 1][j - 1][k] % MOD + dp[i + 1][j - 1][k] % MOD);
					
					dp[i][j][visited] %= MOD;
				}
			}
		}
		
		long ans = 0;
		for (int i = 1; i <= 9; i++) {
			ans += dp[i][len][(1 << 10) - 1];// 여기 %MOD넣으면 1e9넘는 값 더할때 이상하게 더해져서 long으로 큰 값 더해놓고 마무리로 나머지 구하기
		}
		System.out.println(ans % MOD);
	}
}
