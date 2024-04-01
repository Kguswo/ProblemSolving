import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
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
	
	static int V, E, K;
	static ArrayList<Node>[] adj;
	static int[] minlen;
	static boolean[] visited;
	static boolean flag;
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		adj = new ArrayList[V+1];
		minlen = new int[V+1];
		Arrays.fill(minlen, Integer.MAX_VALUE);
		for(int i=0; i<=V; i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			adj[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt()));
		}
		//테스트 출력
//		for(int i=1; i<=V; i++) {
//			for(Node n : adj[i]) {
//				System.out.print(i+"->"+n.end + " 가중치=" + n.W + ", ");
//			}
//			System.out.println();
//		}
		
		dijkstra(K);
//		System.out.println(Arrays.toString(minlen));
		for(int i=1; i<minlen.length; i++) {
			if(i!=K && minlen[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(minlen[i]);
		}
	}
	private static void dijkstra(int k) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		visited = new boolean[V+1];
		minlen[k] = 0;
//		visited[k] = true;

		queue.add(new Node(k, 0));
		while(queue.isEmpty()==false) {
			Node current = queue.poll();
			if(visited[current.end] == true) continue;
			visited[current.end]=true;
			for(Node node : adj[current.end]) {
				if(visited[node.end] == false && minlen[node.end] > minlen[current.end]+ node.W) {
					minlen[node.end] = minlen[current.end] + node.W;
					queue.add(new Node(node.end, minlen[node.end]));
				}
			}
		}
	}
}