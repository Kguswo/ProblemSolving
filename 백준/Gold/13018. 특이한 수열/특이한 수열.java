/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, K, gcdCnt, A[];
	static final String IMPOSSIBLE = "Impossible";
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
		A = new int[N];
		
		if (N == K) {
			System.out.println("Impossible");
			return;
		}
		
		for(int i=0; i<N; i++) {
			A[i] = i+1;
		}
		gcdCnt = N - K - 1; // GCD(1, 1) = 1 이므로 
		
		if(gcdCnt%2 == 0) {
			for(int i=1; i<gcdCnt; i+=2) {
				int tmp = A[i];
				A[i] = A[i+1];
				A[i+1] = tmp;
			}
		}
		else {
			for(int i=0; i<gcdCnt; i+=2) {
				int tmp = A[i];
				A[i] = A[i+1];
				A[i+1] = tmp;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(A[i] + " ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}