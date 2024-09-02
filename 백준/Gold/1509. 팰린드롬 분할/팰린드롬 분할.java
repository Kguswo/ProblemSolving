/**
 * Author : nowalex322, Kim HyeonJae( KR )
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new  BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		String str = br.readLine();
		int len = str.length();
		char[] arr = str.toCharArray();
		
        boolean[][] isPalindrome = new boolean[len][len];
		int[][] dp = new int[len][len];
		
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
            if (i >0 && arr[i-1] == arr[i]) isPalindrome[i-1][i] = true;
        }
        for(int i=3; i<=len; i++) {
        	for(int start=0; start<=len-i; start++) {
        		int end = start+i-1; // 끝 인덱스
        		if(arr[start] == arr[end] && isPalindrome[start+1][end-1]) isPalindrome[start][end] = true;
        	}
        }
		
		for(int i=0; i<len; i++) {
			if(isPalindrome[0][i]) dp[0][i] = 1;
			else {
				dp[0][i] = i+1; // 최악의 경우로 세팅
				for(int j=0; j<i; j++) {
					if(isPalindrome[j+1][i]) dp[0][i] = Math.min(dp[0][i],  dp[0][j] + 1);
				}
			}
		}
//		for(int i=0; i<len; i++) {
//			for(int j=0; j<len; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[0][len-1]);
	}
}
