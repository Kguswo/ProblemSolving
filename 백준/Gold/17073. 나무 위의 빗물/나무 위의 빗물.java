/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
    static int N, W, tree[];
    double leaf, res;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		tree = new int[500010];
		leaf = 0;
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			tree[U]++;
			tree[V]++;
		}
		
		for(int i=2; i<=500000; i++) {
			if(tree[i] == 1) leaf++;
		}
		
		res = W / leaf;
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}
}