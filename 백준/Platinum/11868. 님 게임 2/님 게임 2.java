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

		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int res = Integer.parseInt(st.nextToken());
		for(int i = 1; i < N; i++) {
			res ^= Integer.parseInt(st.nextToken());
		}
		bw.write(res != 0 ? "koosaga" : "cubelover");
		
		bw.flush();
		bw.close();
		br.close();
	}
}