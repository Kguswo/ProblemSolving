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

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
					
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int res = solve(arr, N);
			bw.write(String.valueOf(res) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	/**
	 * A, B, C 가능한 숫자 찾기
	 * 숫자 찾은 후 가능한 경우의 수 리턴
	 * 
	 * @param arr
	 * @param n
	 * @return 가능한 조합 경우의 수
	 */
	private int solve(int[] arr, int N) {
		Set<Integer> nums = new HashSet<Integer>(); // N개의 숫자 가능 후보
		for(int i=0; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				// 각 값 + 0끼리의 차이
				int diff = Math.abs(arr[j] - arr[i]);
				if(diff>0) nums.add(diff);
			}
		}
		
		int cnt = 0;
		for(int A : nums) {
			for(int B : nums) {
				for(int C : nums) {
					if(A>B || B>C) continue; // 1<=A<=B<=C
					if(isAns(A, B, C, arr, N)) cnt++;
				}
			}
		}
		return cnt;
	}

	private boolean isAns(int A, int B, int C, int[] arr, int N) {
		int A_plus_B = A+B;
		int B_plus_C = B+C;
		int C_plus_A = C+A;
		int A_plus_B_plus_C = A+B+C;
		
		for(int i=1; i<=N; i++) {
			if(arr[i] != A && 
			   arr[i] != B && 
			   arr[i] != C && 
			   arr[i] != A_plus_B && 
			   arr[i] != B_plus_C && 
			   arr[i] != C_plus_A && 
			   arr[i] != A_plus_B_plus_C) return false;
		}
		return true;
	}
}