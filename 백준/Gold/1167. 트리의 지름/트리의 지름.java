import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int V;
		int dist;
		public Node(int V, int dist) {
			this.V = V;
			this.dist =  dist;
		}
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	static int N, max, node;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			while(true) {
				int b = Integer.parseInt(st.nextToken());
				if(b == -1) break;
				int value = Integer.parseInt(st.nextToken());
				list[a].add(new Node(b, value));
			}
		}
		
		visited = new boolean[N + 1];
		dfs(1, 0);
		
		visited = new boolean[N+1];
		dfs(node, 0);
		
		System.out.println(max);
				
		
	}
	private static void dfs(int v, int l) {
		if(l > max) {
			max = l;
			node = v;
		}
		visited[v] = true;
		for(int i=0; i<list[v].size(); i++) {
			Node n = list[v].get(i);
			if(!visited[n.V]) {
				dfs(n.V, n.dist + l);
				visited[n.V] = true;
			}
		}
	}
}
