import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Node {
		List<Integer> connect;

		public Node() {
			this.connect = new ArrayList<Integer>();
		}
	}

	static int N, p[];
	static Node[] node;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		node = new Node[N + 1]; // 노드들 들어감
		p = new int [N+1]; // 부모노드 찾아넣음
		visited = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			node[i] = new Node();
		}
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			node[a].connect.add(b);
			node[b].connect.add(a);
		}
		dfs(0, 1);
		for (int i = 1; i <= N; i++) {
		}
		for(int i=2; i<=N; i++) {
			System.out.println(p[i]);
		}
	}

	private static void dfs(int parent, int current) {
	    visited[current] = true;
		p[current] = parent;
	    for(int next : node[current].connect) {
	        if (!visited[next]) {
	            dfs(current, next);
	        }
	    }
	}
}
