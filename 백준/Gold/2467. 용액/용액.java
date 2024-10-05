/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n, arr[];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());		
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans1=0, ans2=0;
		
		int min = Integer.MAX_VALUE;
		int left = 0; int right = n-1;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(Math.abs(sum) < Math.abs(min)) {
				min = sum;
				ans1 = arr[left];
				ans2 = arr[right];
			}
			
			if(sum < 0) left ++;
			else if(sum > 0) right--;
			else break;
		}
		
		bw.write(ans1 + " " + ans2);
		bw.flush();
		bw.close();
		br.close();
	}
}