import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n, board[][], dp[][];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		board = new int[n][n+2];
		dp = new int[n][n+2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1] = board[0][1];
		
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<=i+1; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1] + board[i][j], dp[i-1][j] + board[i][j]);
			}
		}
		
		int maxV = dp[n-1][0];
		for(int j=1; j<=n; j++) {
			maxV = Math.max(maxV, dp[n-1][j]);
		}
		System.out.println(maxV);
	}
}
