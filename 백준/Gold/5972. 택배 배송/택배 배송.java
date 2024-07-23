import java.io.*;
import java.util.*;

public class Main {
	
	static class Delivery implements Comparable<Delivery>{
		int V;
		int W;
		public Delivery(int V, int W){
			this.V = V; // 도착정점
			this.W = W; // 가중치
		}
		
		@Override
		public int compareTo(Delivery o) {
			return this.W - o.W;
		}
		
	}
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, min_hay[];
	static ArrayList<Delivery>[] map;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken()); // 헛간
		M = Integer.valueOf(st.nextToken()); // 간선
		
		map = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.valueOf(st.nextToken());
			int B = Integer.valueOf(st.nextToken());
			int V = Integer.valueOf(st.nextToken());
			
			//양방향연결
			map[A].add(new Delivery(B, V));
			map[B].add(new Delivery(A, V));
		}
		
		min_hay = new int[N+1]; // 정점까지 최소 필요 건초 저장
		Arrays.fill(min_hay, 987654321);
		min_hay[1] = 0;
		// 1 -> N 가기
		dijkstra();
		
        bw.write(String.valueOf(min_hay[N]));
        bw.flush();
        bw.close();
        br.close();
	}
	private static void dijkstra() {
		PriorityQueue<Delivery> pq = new PriorityQueue<Delivery>();
		pq.offer(new Delivery(1, 0));
		
		while(!pq.isEmpty()) {
			Delivery current = pq.poll();
			int currentFrom = current.V;
			int currentCow = current.W;
			
			// 이미 현재까지 건초수가 currentFrom까지의 최소건초보다 크면 다른 경로가 더 최소란 뜻이므로 볼 필요가 없다
			if(currentCow > min_hay[currentFrom]) continue;
			
			for(Delivery d : map[currentFrom]) {
				int newVertex = d.V;
				int newCowSum = currentCow + d.W;
				if(newCowSum < min_hay[newVertex]) {
					pq.offer(new Delivery(newVertex, newCowSum));
					min_hay[newVertex] = newCowSum;
				}
			}
		}
	}
}
