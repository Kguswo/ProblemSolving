/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, C, arr[];
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
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int minLen = 1;
		int maxLen = (arr[N-1] - arr[0]) / (C-1);
		int res = 1;
		
		while(minLen <= maxLen) {
			int mid = minLen + (maxLen-minLen)/2;
			int currPos = arr[0];
			int tmpCnt = 1;
			
			for(int i=1; i<N; i++) {
				if(arr[i] - currPos >= mid) {
					tmpCnt++;
					currPos = arr[i];
				}
			}
			
			if(tmpCnt >= C) {
				res = mid;
				minLen = mid+1;
			}
			else {
				maxLen = mid-1;
			}
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}
}