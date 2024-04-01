import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int start, end, W;
		public Node(int start, int end, int W) {
			this.start=start;
			this.end=end;
			this.W=W;
		}
		@Override
		public int compareTo(Node o) {
			return this.W - o.W;
		}
	}
	
	static int N, M, Wsum, Mcount;
	static int[] parents;
	static PriorityQueue<Node> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		parents = new int [N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		queue = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			queue.add(new Node(sc.nextInt(),sc.nextInt(), sc.nextInt()));
		}
		// 우선순위 큐에 간선들 다 넣음
		Wsum=0; Mcount = 0;
		while(Mcount < N-1) {
			Node current = queue.poll();
			if(find(parents, current.start) != find(parents, current.end)) {
				union(parents, find(parents, current.start), find(parents, current.end));
				Wsum += current.W;
				Mcount++;
			}
		}
		System.out.println(Wsum);
	}

	private static void union(int[] parents, Object start, Object end) {
		parents[(int) end] = (int) start;
	}

	private static int find(int[] parents, int start) {
		if(start != parents[start]) parents[start] = (int) find(parents, parents[start]);
		return parents[start];
	}
}