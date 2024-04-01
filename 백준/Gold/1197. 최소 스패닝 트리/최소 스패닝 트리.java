import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node> {
		int start, end, W;

		public Node(int start, int end, int W) {
			this.start = start;
			this.end = end;
			this.W = W;
		}

		@Override
		public int compareTo(Node o) {
			return this.W - o.W;
		}
	}

	static int V, E, Wsum, Vcount;
	static int[] parent;
	static PriorityQueue<Node> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		queue = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			queue.add(new Node(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		// 우선순위 큐에 모든 정점들이 들어가 있는 상태
		int Wsum = 0;
		int Vcount = 0;
		while (Vcount < V - 1) {
			Node current = queue.poll();
			if(find(parent, current.start) != find(parent,current.end)) {
				union(parent,find(parent, current.start), find(parent,current.end) );
				Wsum += current.W;
				Vcount++;
			}
		}
		System.out.println(Wsum);
	}

	private static void union(int[] p, Object start, Object end) { // 시작set 밑으로 끝set 넣기
		p[(int) end] =(int) start;
	}

	private static int find(int[] p, int start) {
		if(start != p[start]) p[start] = find(p, p[start]);
 		return p[start];
	}
}