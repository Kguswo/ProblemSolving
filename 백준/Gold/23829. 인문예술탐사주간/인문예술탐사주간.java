/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, Q, tree[];
	static long prefixSum[];
	static long sum;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		tree = new int [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);		
		
		prefixSum = new long[N+1];
		/*
		 * 처음아이디어 : 맨 왼쪽부터 진행해 나무 한그루씩 지나칠때마다 -2씩 되므로 이를 반영하여 누적합 -> 첫 O(N) 이후 쿼리마다 O(1)
		 * 			   -> 절댓값 계산 문제 발생
		 * 다음아이디어 : 왼쪽 오른쪽을 따로 해서 절댓값 오류까지 해결 ->  O(NlogN)
		 */
		for(int i=1; i<=N; i++) {
			prefixSum[i] = prefixSum[i-1] + tree[i-1];
		}
		
		for(int i=0; i<Q; i++) {
			int pos = Integer.parseInt(br.readLine());
			int left = findIdx(pos);
			long leftSum = (long) left * pos - prefixSum[left];
			long rightSum = (long) (prefixSum[N] - prefixSum[left]) - (long) pos * (N-left);
			
			sb.append(leftSum + rightSum).append("\n");
		}
						
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private int findIdx(int pos) {
		int res = 0;
		int left = 0, right = tree.length-1;

        if(pos < tree[0]) return 0;

		while(left <= right) {
			int mid = left + (right-left) / 2;
			if(tree[mid] <= pos) {
				left = mid + 1;
				res = mid;
			}
			else {
				right = mid-1;
			}
		}
		return res+1; // 인덱스 0부턴데 개수반환해야하므로
	}
}