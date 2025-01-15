/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][2];
		int[] dp = new int[N+1];
		Arrays.fill(dp, 1);
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
		}
		int res = 1;
		
		Arrays.sort(board, (o1, o2) -> o1[0] - o2[0]);
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				if(board[i][1] > board[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			res = Math.max(dp[i], res);
		}

		bw.write(String.valueOf(N - res));
		bw.flush();
		bw.close();
		br.close();
	}
}