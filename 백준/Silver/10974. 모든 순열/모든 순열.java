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
	static int N, number[];

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		number = new int[N];
		permutation(0, 0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private void permutation(int depth, int visited) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				sb.append(number[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if ((visited & (1 << (i - 1))) == 0) {
				number[depth] = i;
				permutation(depth+1, visited | (1 << (i-1)));
			}
		}
	}
}