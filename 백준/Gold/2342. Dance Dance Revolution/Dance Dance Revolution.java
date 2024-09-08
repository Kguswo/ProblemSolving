/**
 * Author : nowalex322, Kim Hyeonjae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int dp[][][], n=0, cnt=0;
	static int board[][] = {{0,2,2,2,2},
							{2,1,3,4,3},
							{2,3,1,3,4},
							{2,4,3,1,3},
							{2,3,4,3,1}};
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		dp = new int[100010][5][5];
		for(int k=0; k<100010; k++) {
		    for(int i=0; i<5; i++) {
		    	for(int j=0; j<5; j++) {
		    		dp[k][i][j] = 987654321;
		    	}
		    }
		}
		dp[0][0][0] = 0;
		st = new StringTokenizer(br.readLine());
		
        while(st.hasMoreTokens()) {
            n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            
            cnt++;

			for(int i=0; i<5; i++) {
				// 같은곳에 같은발 2개 불가능
				if(n==i) continue;
				for(int j=0; j<5; j++) {
					// 오른발 옮겨서 현재모습 됐을 때 최소 힘
					// dp[cnt-1][i][j] + board[j][n] : 이전 모든 경우의 수 + j=>n으로 오른발 옮기기
					dp[cnt][i][n] = Math.min(dp[cnt-1][i][j] + board[j][n], dp[cnt][i][n]);
				}
			}
			
			for(int j=0; j<5; j++) {
				// 같은곳에 같은발 2개 불가능
				if(n==j) continue;
				for(int i=0; i<5; i++) {
					// 왼발 옮겨서 현재모습 됐을 때 최소 힘
					// dp[cnt-1][i][j] + board[i][n] : 이전 모든 경우의 수 + j=>n으로 왼발 옮기기
					dp[cnt][n][j] = Math.min(dp[cnt-1][i][j] + board[i][n], dp[cnt][n][j]);
				}
			}
		}
        
		int min = Integer.MAX_VALUE;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				min = Math.min(min,  dp[cnt][i][j]);
			}
		}
		System.out.println(min);
	}
}