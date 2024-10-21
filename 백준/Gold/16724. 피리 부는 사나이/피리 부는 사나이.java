/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static char[][] board;
	static int p[], N, M;
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p = new int[N * M];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String dir = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = dir.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int newr, newc;
				switch (board[i][j]) {
					case 'U': {
						int k = 0;
						newr = i + dr[k];
						newc = j + dc[k];
						break;
					}
					case 'D': {
						int k = 1;
						newr = i + dr[k];
						newc = j + dc[k];
						break;
					}
					case 'L': {
						int k = 2;
						newr = i + dr[k];
						newc = j + dc[k];
						break;
					}
					case 'R': {
						int k = 3;
						newr = i + dr[k];
						newc = j + dc[k];
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + board[i][j]);
				}
				union(i*M + j, newr * M + newc);
				
			}
		}
		
		Set<Integer> set = new  HashSet<Integer>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				set.add(find(i*M+j));
			}
		}
		bw.write(String.valueOf(set.size()));
		bw.flush();
		bw.close();
		br.close();
	}

	private int find(int x) {
		if(p[x] != x) p[x] = find(p[x]);
		return p[x];
	}

	private void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if(a != b) {
			if(a<b) p[a] = b;
			else p[b] = a;
		}
	}
}