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

	static PriorityQueue<Integer> ASC_PQ = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> DESC_PQ = new PriorityQueue<Integer>(Collections.reverseOrder());
	static int N, arr[], dp[], cnt;

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j]+1) dp[i] = dp[j]+1;
			}
		}
		cnt = dp[0];
		for(int i=1; i<dp.length; i++) {
			cnt = Math.max(cnt, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		
		bw.write(String.valueOf(arr.length-cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}