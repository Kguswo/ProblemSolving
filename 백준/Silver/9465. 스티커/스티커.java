import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int T, n, board[][], dp[][];
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		T = Integer.parseInt(br.readLine());
		int tc;
		for(tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			board = new int[2][n];
			dp = new int[2][n+1];
			
			int i;
			for(i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				int j;
				for(j=0; j<n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = 0; dp[1][0] = 0;
			dp[0][1] = board[0][0]; dp[1][1] = board[1][0];
			
			int k ;
			for(k=2; k<=n; k++) {
				dp[0][k] = Math.max(dp[1][k-1] + board[0][k-1], dp[1][k-2] + board[0][k-1]);
				dp[1][k] = Math.max(dp[0][k-1] + board[1][k-1], dp[0][k-2] + board[1][k-1]);
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
