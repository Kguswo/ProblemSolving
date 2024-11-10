
/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, arr[], res;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		int left = 1;
		int right = -987654321;
		res = 0;
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}

		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (canDivideBead(mid)) {
				right = mid - 1;
				res = mid;
			} else {
				left = mid + 1;
			}
		}
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private boolean canDivideBead(int mid) {
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			cnt += (arr[i] % mid) == 0 ? arr[i]/mid : arr[i]/mid + 1;
		}
		return cnt <= N;
	}
}