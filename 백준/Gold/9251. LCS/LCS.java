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
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i][j]);
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
//		for(int i=0; i<=str1.length(); i++) {
//			for(int j=0; j<=str2.length(); j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		bw.write(String.valueOf(dp[str1.length()][str2.length()]));
		bw.flush();
		bw.close();
		br.close();
	}
}