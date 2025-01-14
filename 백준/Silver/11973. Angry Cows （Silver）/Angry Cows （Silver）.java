/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, arr[], res;
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
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int left = 0;
		int right = (arr[N-1] - arr[0]); 
		
		while(left <= right) {
			int mid = left + (right - left)/2;
			if(count(2 * mid)) {
				res = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}
	
	private boolean count(int mid) {
		int cnt = 1;
		int start = 0;
		for(int i=1; i<N; i++) {
			if(arr[i] - arr[start] > mid) {
				cnt++;
				start = i;
			}
			if(cnt > K) return false;
		}
		return cnt <= K;
	}
}