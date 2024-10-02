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
		// br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/*
		 * 완벽하게 게임 시 남은 개수로 승리조건 분석
		 * 1개 : 시작하는 사람 승 
		 * 2개 : 두번쨰 사람 승 
		 * 3개 : 시작하는 사람 승 
		 * 4개 : 두번째 사람 
		 * 5개 : 시작하는 사람 
		 * 즉 서로 홀수개밖에 사지 못하므로 홀수개가 남으면 시작하는사람 승, 짝수개가 남으면 두번째 사람 승이다  
		 */
		
		int N = Integer.parseInt(br.readLine());
		
		if(N %2 == 1) bw.write("SK");
		else bw.write("CY");
		
		bw.flush();
		bw.close();
		br.close();
	}
}