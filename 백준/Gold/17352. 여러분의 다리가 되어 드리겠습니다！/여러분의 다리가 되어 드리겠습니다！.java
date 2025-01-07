/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, p[];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		if (N==2) {
			System.out.print("1 2");
			return;
		}
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}

		int group1=1, group2=0;
		
		for(int i=0; i<N-2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());			
			union(a, b);
		}
		
		for(int i=2; i<=N; i++) {
	        if(find(i) != find(group1)) {
	            group2 = i;
	            break;
	        }
	    }
		
		bw.write(String.valueOf(group1) + " " + String.valueOf(group2));
		bw.flush();
		bw.close();
		br.close();
	}

	private void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px != py) {
			if(px < py) p[py] = px;
			else p[px] = py;
		}
	}
	
	private int find(int x) {
		if(p[x] != x) return p[x] = find(p[x]);
		return p[x];
	}
}