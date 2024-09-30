/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n, m, p[];

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[n];
		for(int i=0; i<p.length; i++) {
			p[i] = i;
		}
		
		int cnt = 0; 
		boolean flag = false;
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			if(!flag) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				boolean isCycled = union(start, end);
				if(isCycled) {
					cnt=i;
					flag = true;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		

		bw.flush();
		bw.close();
		br.close();
	}

	private boolean union(int start, int end) {
		int p1 = find(start);
		int p2 = find(end);
		
		if(p1 == p2) return true;
		else {
			p[p2] = p1;
			return false;
		}
	}

	private int find(int start) {
		if(p[start] != start) return p[start] = find(p[start]);
		return p[start];
	}
}