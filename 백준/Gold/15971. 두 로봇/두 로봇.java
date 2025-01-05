/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	class Node{
		int to;
		int W;
		public Node(int to, int W){
			this.to = to;
			this.W = W;
		}
	}
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, robot1, robot2, first, second, w, totalD, maxW;
	static ArrayList<Node>[] map;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		robot1 = Integer.parseInt(st.nextToken());
		robot2 = Integer.parseInt(st.nextToken());

		if(N == 1 || robot1 == robot2) {
	        bw.write("0");
	        bw.flush();
	        bw.close();
	        br.close();
	        return;
	    }
		
		map = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			map[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map[first].add(new Node(second, w));
			map[second].add(new Node(first, w));
		}
		
		visited = new boolean[N+1];
		totalD = 0;
		maxW = 0;
		
		dfs(robot1, robot2);
		bw.write(String.valueOf(totalD - maxW));
		bw.flush();
		bw.close();
		br.close();
	}

	private boolean dfs(int start, int end) {
		if(start == end) {
			return true;
		}
		
		visited[start] = true;
		
		for(Node n : map[start]) {
			if(!visited[n.to]) {
				int prevMax = maxW;
				maxW = Math.max(maxW, n.W);
				totalD += n.W;
				
				if(dfs(n.to, end)) return true;
				
				// 백트래킹
				totalD -= n.W;
				maxW = prevMax;				
			}
		}
		
	    // 경로를 못 찾았을 때 백트래킹 및 초기화
		visited[start] = false;
		maxW = 0;
		return false;
	}
}