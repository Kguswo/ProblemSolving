/**
 * Author : nowalex322, Kim Hyeonjae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static long[][] dp;
	static char[] str1, str2;
	static ArrayList<Character> LCS;
	static int N, M, inDegree[];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();
		
		
		dp = new long[str1.length+1][str2.length+1];
		LCS = new  ArrayList<Character>();
		for(int i=1; i<str1.length+1; i++) {
			for(int j=1; j<str2.length+1; j++) {
				if(str1[i-1] == str2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
		getLCS(str1.length, str2.length);
		
		bw.write((int) dp[str1.length][str2.length] + "\n");
		makeLCS();
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void makeLCS() throws IOException {
		for(int i=LCS.size()-1; i>=0; i--) {
			bw.write(LCS.get(i));
		}
	}

	/**
	 * LCS 문자열구하기
	 */
	private static void getLCS(int i, int j) {
		if(i==0 || j==0) return;
		if(str1[i-1]==str2[j-1]) {
			LCS.add(str1[i-1]);
			getLCS(i-1, j-1);
		}
		else {
			if(dp[i-1][j] > dp[i][j-1]) getLCS(i-1, j);
			else getLCS(i, j-1);
		}
	}
	
	
}