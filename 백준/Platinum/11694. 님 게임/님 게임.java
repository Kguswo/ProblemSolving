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
		int first = Integer.parseInt(st.nextToken());
		
		if(N==1) {
			System.out.println(first==1? "cubelover" : "koosaga");
			return;
		}
		
		int XOR = first;
		boolean flag = (first == 1); // 모든 숫자가 1인지 check
		
		for(int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			XOR ^= num;
			if(num != 1) flag = false;
		}
		if(flag == true) bw.write(N%2==1? "cubelover" : "koosaga");
		else bw.write(XOR==0? "cubelover" : "koosaga");
		
		bw.flush();
		bw.close();
		br.close();
	}
}