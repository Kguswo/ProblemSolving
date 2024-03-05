import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, start, end;
	static int count = 0;
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		N = sc.nextInt();
		M = sc.nextInt();
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=M; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			
			A[start].add(end);
			A[end].add(start);
		}
		
		bfs(1);
		System.out.println(count);
		
	}
	static void bfs(int v) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v]=true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			for(int i : A[current]) {
				if(!visited[i]) {
					count++;
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
