/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
	static int N, M, k;
	static int[] price, p;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16562_친구비/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		price = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		p = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			p[i] = i;
		}
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(find(a) != find(b)){
				union(a ,b);
			}
		}

		Map<Integer, Integer> group = new HashMap<>();
		for(int i=1; i<=N; i++){
			int pi = find(i);
			group.put(pi, Math.min(group.getOrDefault(pi, Integer.MAX_VALUE), price[i-1]));
		}

		int res = 0;
		for(int n : group.values()){
			res += n;
		}

		if(res <= k) System.out.println(res);
		else System.out.println("Oh no");

        bw.flush();
        bw.close();
        br.close();
    }

	private void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px != py) p[py] = px;
	}

	private int find(int x) {
		if(p[x] != x) p[x] = find(p[x]);
		return p[x];
	}
}