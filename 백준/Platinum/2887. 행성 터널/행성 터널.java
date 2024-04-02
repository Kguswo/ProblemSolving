import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Planet{
		int n, x, y, z;
		public Planet(int n, int x, int y, int z) {
			this.n = n;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Node implements Comparable<Node>{
		int start, end;
		double W;
		public Node(int start, int end, double W) {
			this.start = start;
			this.end = end;
			this.W = W;
		}
		@Override
		public int compareTo(Node o) {
			return (int) (this.W - o.W);
		}
	}
	static int N, Vcount;
	static double minlen, x, y, distance;
	static int[] parents;
	static double[][] coordinate;
	static PriorityQueue<Node> queue;
	static Planet[] planet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parents = new int[N+1];
		coordinate = new double[N][3];
		queue = new PriorityQueue<Node>();
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		
		planet = new Planet[N];

		for(int i=0; i<N; i++) {
			planet[i] = new Planet(i+1, sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(planet, (list1, list2) -> Integer.compare(list1.x, list2.x));
		for(int i=1; i<N; i++) {
			queue.add(new Node(planet[i].n, planet[i-1].n, planet[i].x-planet[i-1].x));
		}
		
		Arrays.sort(planet, (list1, list2) -> Integer.compare(list1.y, list2.y));
		for(int i=1; i<N; i++) {
			queue.add(new Node(planet[i].n, planet[i-1].n, planet[i].y-planet[i-1].y));
		}
		
		Arrays.sort(planet, (list1, list2) -> Integer.compare(list1.z, list2.z));
		for(int i=1; i<N; i++) {
			queue.add(new Node(planet[i].n, planet[i-1].n, planet[i].z-planet[i-1].z));
		}

		// 우선순위 큐 준비완료
		minlen = 0; Vcount = 0;
		while(Vcount<N-1) {
			Node current = queue.poll();
			if(find(current.start) != find(current.end)) {
				union(find(current.start), find(current.end));
				Vcount ++;
				minlen += current.W;
			}
		}
		System.out.println((int) minlen);
	}
	private static void union(Object start, Object end) {
		parents[(int) end] = (int) start;
	}
	private static int find(int start) {
		if(start != parents[start]) parents[start] = find(parents[start]);
		return parents[start];
	}
}