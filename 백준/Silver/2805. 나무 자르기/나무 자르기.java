/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, arr[];
	static long M;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 1; int right = arr[arr.length-1];
		int res = 0;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(lessThanM(mid)) {
				left = mid + 1;
				res = mid;
			}
			else {
				right = mid-1;
			}
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private boolean lessThanM(int mid) {
		long sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > mid) sum += arr[i] - mid;
		}
		return sum >= M;
	}
}