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
		p = new int[2*N + 1];
		for(int i=0; i<p.length; i++) {
			p[i] = i;
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> o1[0]-o2[0]);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int p3 = Integer.parseInt(st.nextToken());
			int p4 = Integer.parseInt(st.nextToken());
			pq.add(new int[] {c, p1, p3});
			union(p1, p2);
			union(p3, p4);
		}
		int res = 0;
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			if(union(curr[1], curr[2])) res += curr[0];
		}
		bw.write(String.valueOf(res));

		bw.flush();
		bw.close();
		br.close();
	}

	private boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py) return false;
		p[py] = px;
		return true;
	}
	
	private int find(int x) {
		if(p[x] != x) return p[x] = find(p[x]);
		return x;
	}
}