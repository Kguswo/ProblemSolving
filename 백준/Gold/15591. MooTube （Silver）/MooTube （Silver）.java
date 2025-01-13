/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	class Node{
		int from, to, v;
		public Node(int from, int to, int v) {
			this.from = from;
			this.to = to;
			this.v = v;
		}
	}
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, Q, board[][], p, q, r, k, v;
	static ArrayList<Node>[] related;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		board = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
		    Arrays.fill(board[i], Integer.MAX_VALUE);
		}
		related = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			related[i] = new ArrayList<Node>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			related[p].add(new Node(p, q, r));
			related[q].add(new Node(q, p, r));
			board[p][q] = r;
			board[q][p] = r;
		}
		
		for(int i=1; i<=N; i++) {
			bfs(i);
		}
		
		int res = 0;
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			res = 0;
			for(int j=1; j<=N; j++) {
				if(j != v && board[v][j] >= k) res++;
			}
			sb.append(res).append("\n");
		}
		
//		for(int i=1; i<N; i++) {
//			for(int j=1; j<N; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new boolean[N+1];
		
		queue.offer(i);
		visited[i] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			for(Node n : related[curr]) {
				if(!visited[n.to]) {
					board[i][n.to] = Math.min(board[i][curr], n.v);
					queue.offer(n.to);
					visited[n.to] = true;
				}
			}
		}
	}
}