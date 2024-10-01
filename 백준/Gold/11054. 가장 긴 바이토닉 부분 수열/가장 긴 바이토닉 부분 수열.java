/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, A[], ASC[], DESC[], ans[];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		A = new int [N];
		ASC = new int [N];
		DESC = new int [N];
		ans = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순
		for(int i=0; i<N; i++) {
			ASC[i] = 1;
			for(int j=0; j<i; j++) {
				if(A[j] < A[i] && ASC[i] < ASC[j] + 1) ASC[i] = ASC[j] + 1;
			}
		}
		
		// 내림차순
		for(int i=N-1; i>=0; i--) {
			DESC[i] = 1;
			for(int j=N-1; j>i; j--) {
				if(A[j] < A[i] && DESC[i] < DESC[j] + 1) DESC[i] = DESC[j] + 1;
			}
		}
		
		int max = -987654321;
        for (int i = 0; i < N; i++) {
            ans[i] = ASC[i] + DESC[i] - 1;
            max = Math.max(max, ans[i]);
        }
		
        bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}
}
