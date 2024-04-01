import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int end, W;
		public Node(int end, int W) {
			this.end = end;
			this.W = W;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.W, o.W);
		}
		
	}
	
	static int N, M, start_point, end_point;
	static ArrayList<Node>[] adj;
	static boolean[] visited;
	static int[] minlen;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adj = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			adj[i] = new ArrayList<Node>();
		}
		for(int i=0; i<M; i++) {
			adj[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		start_point = sc.nextInt();
		end_point = sc.nextInt();
		minlen = new int [N+1];
		Arrays.fill(minlen, Integer.MAX_VALUE);
		dijkstra(start_point);
		System.out.println(minlen[end_point]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		visited = new boolean[N+1];
		minlen[start] = 0;
		
		queue.offer(new Node(start, 0));
		while(queue.isEmpty() == false) {
			Node current = queue.poll();
			if(visited[current.end] == true) continue;
			visited[current.end] = true;
			for(Node node : adj[current.end]) {
				if(visited[node.end]==false && minlen[node.end] > minlen[current.end] + node.W) {
					minlen[node.end] = minlen[current.end] + node.W;
					queue.add(new Node(node.end, minlen[node.end]));
				}
			}
		}
	}
}