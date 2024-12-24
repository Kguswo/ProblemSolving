/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, arr[];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		int left = 1;
		int right = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}
		
		int res = 0;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(calPeopleCount(mid)) {
				res = Math.max(res, mid);
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private boolean calPeopleCount(int mid) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			cnt += arr[i] / mid;
		}
		return cnt >= K;
	}
}