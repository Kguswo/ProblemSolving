/**
 * Author : nowalex322, Kim Hyeonjae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M, degree[];
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		degree = new int[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			degree[B]++;
		}
		solve();
		System.out.println(sb.toString());
		
	}
	private static void solve() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=1; i<=N; i++) {
			if(degree[i] == 0) pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int curr = pq.poll();
			solveProblem(curr);
			sb.append(curr + " ");
			
			for(int next : list[curr]) {
				if(degree[next]==0) pq.add(next);
			}
		}
	}
	private static void solveProblem(int curr) {
		for(int n : list[curr]) degree[n]--;
	}
}
