
/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M, arr[], left, right, mid;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		left = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right= Math.max(right, arr[i]);
		}
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (countSection()) {
				right = mid -1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}

	private static boolean countSection() {
		int cnt = 1;
		int min = 987654321;
		int max = -min;
		for (int i = 0; i < N; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			int gap = max - min;
			if (gap > mid) {
				cnt++;
				i--;
				min = 987654321;
				max = -min;
			}
		}
		return cnt <= M;
	}
}
