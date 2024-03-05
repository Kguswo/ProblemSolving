import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, V;
	static ArrayList<Integer>[] A;
	static boolean visited[];
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));	
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		A = new ArrayList[N+1];			
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();			
		}
		
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			A[start].add(end);
			A[end].add(start);
		}
		for(int i=1; i<=N; i++) {
			Collections.sort(A[i]);
		}
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
		

	}
	private static void dfs(int v) {
		System.out.print(v + " ");
		visited[v] = true;
		for(int i : A[v]) {
			if(!visited[i]) dfs(i);
		}
	}
	
	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		visited[v] = true;
		
		while (queue.isEmpty()==false) {
			int current = queue.poll();
			
			System.out.print(current + " ");
			for(int i : A[current]) {
				if(!visited[i]) {
					queue.offer(i);
					visited[i]=true;
				}
			}			
		}				
	}
}
