import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parents = new int[N+1];
		coordinate = new double[N][2];
		queue = new PriorityQueue<Node>();
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		for(int i=0; i<N; i++) {
			coordinate[i][0] = sc.nextDouble(); // x좌표
			coordinate[i][1] = sc.nextDouble(); // y좌표
		}
		getinfo();
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
		System.out.println(minlen);
	}
	private static void union(Object start, Object end) {
		parents[(int) end] = (int) start;
	}
	private static int find(int start) {
		if(start != parents[start]) parents[start] = find(parents[start]);
		return parents[start];
	}
	private static double caldistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
	}
	private static void getinfo() {
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				queue.add(new Node(i+1, j+1, caldistance(coordinate[i][0], coordinate[i][1], coordinate[j][0], coordinate[j][1])));
			}
		}
	}
}