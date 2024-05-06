import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int N, K, count = 0, pathArr[] = new int[100001];
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		bfs(N, K);
	}

	private static void bfs(int startnum, int targetnum) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> path = new LinkedList<Integer>();
		
		queue.offer(startnum);
		path.offer(startnum);
		visited[startnum] = true;
		pathArr[startnum] = -1;

		while (!queue.isEmpty()) {
			int qsize = queue.size();
			for (int i = 0; i < qsize; i++) {
				int current = queue.poll();
				path.offer(current);
				if(current == targetnum) {
					showPath(path, current);
					return;
				}
		
				if (current + 1 <= 100000 && !visited[current + 1]) {
					queue.offer(current + 1);
					visited[current + 1] = true;
					pathArr[current+1] = current;
				}
				if (current - 1 >= 0 && !visited[current - 1]) {
					queue.offer(current - 1);
					visited[current - 1] = true;
					pathArr[current-1] = current;
				}
				if (current * 2 <= 100000 && !visited[current * 2]) {
					queue.offer(current * 2);
					visited[current * 2] = true;
					pathArr[current*2] = current;
				}
			}
			count++;
		}
	}

	private static void showPath(Queue<Integer> path, int current) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(current);
		StringBuilder sb = new StringBuilder();
		while(!(pathArr[current] == -1)) {
			current = pathArr[current];
			stack.add(current);
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		System.out.println(count);
		System.out.println(sb.toString().trim());
		
	}
}
