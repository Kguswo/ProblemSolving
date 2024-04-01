import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
	Node클래스를 만들기 연습.(가중치 있을 때 대비)
	아이디어 : 노드에 끝 정점 값을 저장. 정점사이 길이 1이므로 가중치는 필요 x
	시작점을 인덱스로, 도착점을 node.end로 만들고 각 인덱스(첫 정점)에 전부 넣어줌
	minlen배열에 각 도착점까지의 최소거리를 저장할 것임.
	BFS : 시작점 X에서 BFS로 인덱스X에 인접한 점 queue에 넣고, 처음 자기자신부터 시작하여 길이 0
	minlen[X]에서 연결된 정점들로 이동하며 방문하지 않은점으로 이동하고, 방문표시.
	minlen[도착 정점] = minlen[출발정점] + 1로 갱신.
	이 방법을 통해 가장 먼저 그 점에 도착할 때 거리를 저장하므로 최소 거리가 저장됨.
	모든 점 방문(bfs종료) -> minlen배열에서 찾고자 하는 K길이인 도착점들 순회하며 찾기
*/
public class Main {

	static class Node {
		int end;

		public Node(int end) {
			this.end = end;
		}
	}

	static int N, M, K, X, len;
	static ArrayList<Node>[] adj;
	static int[] minlen;
	static boolean[] visited;
	static Queue<Node> queue;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();
		adj = new ArrayList[N + 1];
		minlen = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			adj[sc.nextInt()].add(new Node(sc.nextInt()));
		}

		bfs(X);

		for (int i = 1; i <= N; i++) {
			if (minlen[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		if(!flag) System.out.println(-1);
	}

	private static void bfs(int x) {
		queue = new LinkedList<Node>();
		visited = new boolean[N + 1];

		minlen[x] = 0;
		visited[x] = true;
		queue.offer(new Node(x));

		while (queue.isEmpty() == false) {
			Node current = queue.poll();
			for (Node node : adj[current.end]) {
				if (visited[node.end] == false) {
					minlen[node.end] = minlen[current.end] + 1;
					queue.offer(node);
					visited[node.end] = true;
				}
			}
		}
	}
}