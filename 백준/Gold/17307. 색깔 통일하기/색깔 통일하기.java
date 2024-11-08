/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, C, colors[];
	static long rightPrefixSum[], leftPrefixSum[], finalCnt[];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		colors = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			colors[i] = Integer.parseInt(st.nextToken());
		}
		
		rightPrefixSum = new long[N];
		leftPrefixSum = new long[N];
		rightPrefixSum[0] = 0;
		leftPrefixSum[N-1] =0;
		
		for(int i=1; i<N; i++) {
			int y = colors[i];
			int x = colors[i-1];
//			System.out.print(x + " 에서 " + y + " 까지 가는데  ");
			rightPrefixSum[i] = rightPrefixSum[i-1] + calButtonClickCnt(x, y);
//			System.out.println("만큼 걸려");
		}
		
		for(int i=0; i<N; i++) {
			long tmp = rightPrefixSum[i];
			rightPrefixSum[i] = rightPrefixSum[N-1] - tmp;
		}
		
		for(int i=N-2; i>=0; i--) {
			int y = colors[i];
			int x = colors[i+1];
//			System.out.print(x + " 에서 " + y + " 까지 가는데  ");
			leftPrefixSum[i] = leftPrefixSum[i+1] + calButtonClickCnt(x, y);
//			System.out.println(" 만큼 걸려");
		}
		
		for(int i=N-1; i>=0; i--) {
			long tmp = leftPrefixSum[i];
			leftPrefixSum[i] = leftPrefixSum[0] - tmp;
		}
		
		finalCnt = new long[N];
		long res = Long.MAX_VALUE;
		int residx = -1;
		for(int i=0; i<N; i++) {
			finalCnt[i] = Math.max(leftPrefixSum[i], rightPrefixSum[i]);
			if (finalCnt[i] < res) {
	            res = finalCnt[i];
	            residx = i;
	        }
		}
		
//		System.out.println(Arrays.toString(colors));
//		System.out.println(Arrays.toString(rightPrefixSum));
//		System.out.println(Arrays.toString(leftPrefixSum));
//		System.out.println(Arrays.toString(finalCnt));
			
		
		bw.write(String.valueOf(residx+1 + "\n" + res));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static long calButtonClickCnt(int x, int y) {
//		System.out.print((y+C-x) %C);
		return (y+C-x) %C;
	}
}