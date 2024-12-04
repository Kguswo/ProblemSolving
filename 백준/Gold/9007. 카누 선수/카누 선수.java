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
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int[][] C = new int[4][n];
			
			for(int c=0; c<4; c++) {
				st = new StringTokenizer(br.readLine());
				for(int num=0; num<n; num++) {
					C[c][num] = Integer.parseInt(st.nextToken());
				}
			}			
			
			int[] C1plusC2 = new int[n*n];
			int[] C3plusC4 = new int[n*n];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					C1plusC2[i*n+j] = C[0][i] + C[1][j];
					C3plusC4[i*n+j] = C[2][i] + C[3][j];
				}
			}
			
//			C1plusC2 = Arrays.stream(C1plusC2)
//							 .sorted()
//							 .toArray();
//			C3plusC4 = Arrays.stream(C3plusC4)
//					.sorted()
//					.toArray();
			Arrays.sort(C1plusC2);
			Arrays.sort(C3plusC4);
	       
			int minDiff = Math.abs(k - (C1plusC2[0] + C3plusC4[0]));
			int res = C1plusC2[0] + C3plusC4[0];
   
	        for(int i=0; i<C1plusC2.length; i++) {
	        	int target = k-C1plusC2[i];
	            int left = 0, right = C3plusC4.length-1;
	           
	            while(left <= right) {
	                int mid = left + (right - left)/2;
	                int sum = C1plusC2[i] + C3plusC4[mid];
	                int diff = k - sum;
	               
	                if(Math.abs(diff) < minDiff || (Math.abs(diff) == minDiff && sum < res)) {
	                    minDiff = Math.abs(diff);
	                    res = sum;
	                }
	               
	                if(diff == 0) break;
	                if(diff > 0) left = mid+1;
	                else right = mid-1;
	            }
	       }
	       
	       bw.write(String.valueOf(res)+"\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}