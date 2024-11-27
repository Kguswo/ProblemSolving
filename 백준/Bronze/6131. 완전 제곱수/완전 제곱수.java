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
		int cnt = 0;
		int A, B;
		
		for(int i = 1; i <= 500; i++) {
			B = i;
			A = (int) Math.sqrt((B * B) + N);
			
			if((A * A) - N == B * B) {
				cnt++;
			}
		}
        bw.write(String.valueOf(cnt));		
		bw.flush();
		bw.close();
		br.close();
	}
}