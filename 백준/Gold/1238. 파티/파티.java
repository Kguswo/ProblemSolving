import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int v, w;
		
		public Node(int v, int w) { // v : 도착점, w : 가중
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int N, M, X;
	static List<Node>[] adjList_from_X, adjList_to_X;
	static int[] distance_from_X, distance_to_X;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt()-1;
		adjList_from_X = new ArrayList[N];
		adjList_to_X = new ArrayList[N];
		for(int i=0; i<N; i++) {
			adjList_from_X[i] = new ArrayList<>();
			adjList_to_X[i] = new ArrayList<>();
		}
		
		distance_from_X = new int[N];
		distance_to_X = new int[N];
		Arrays.fill(distance_from_X, Integer.MAX_VALUE);		
		Arrays.fill(distance_to_X, Integer.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
            int S = sc.nextInt() - 1; 
            int E = sc.nextInt() - 1;
            int V = sc.nextInt();
            adjList_from_X[S].add(new Node(E, V));
            adjList_to_X[E].add(new Node(S, V));
        }
		dijkstra(X, adjList_from_X, distance_from_X);
		dijkstra(X, adjList_to_X, distance_to_X);
		int ans = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if (i != X) ans = Math.max(ans, distance_to_X[i] + distance_from_X[i]);
		}
		System.out.println(ans);
	}
	private static void dijkstra(int start, List<Node>[] adjList, int[] distance) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		distance[start] = 0;
		
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			if(visited[current.v]) continue;
			visited[current.v] = true;
			for(Node node : adjList[current.v]) {
				if(!visited[node.v] && distance[current.v] + node.w < distance[node.v]) {
					distance[node.v] = distance[current.v] + node.w;
					pq.add(new Node(node.v, distance[node.v]));
				}
			}
		}
		
	}
}