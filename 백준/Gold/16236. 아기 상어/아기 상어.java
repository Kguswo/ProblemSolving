import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static class Node implements Comparable<Node> {
		int r, c, d;

		public Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			if (this.d == o.d) {
				if (this.r == o.r) {
					return this.c - o.c;
				} else {
					return this.r - o.r;
				}
			}
			return this.d - o.d;
		}
	}

	static int[] di = { -1, 0, 1, 0 }, dj = { 0, 1, 0, -1 };
	static int N, board[][], time = 0, size = 2, eatcount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] == 9) {
					r = i;
					c = j;
					board[i][j] = 0;
				}
			}
		}

		while (true) {
			Node node = findFish(r, c); // 새로 이동할때마다 다음 칸 찾기
			if (node == null)
				break;

			r = node.r;
			c = node.c;
			time += node.d;
			board[r][c] = 0;
			eatcount++;

			if (eatcount == size) {
				size++;
				eatcount = 0;
			}
		}
		System.out.println(time);
	}

	private static Node findFish(int r, int c) {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(r, c, 0));
		visited[r][c] = true;

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (board[current.r][current.c] < size && board[current.r][current.c] != 0
					&& board[current.r][current.c] != 9) { // current를 잡아먹을 수 있음
//				board[current.r][current.c] = 0; 
//				System.out.println("먹힐 곳 : " + current.c + " " + current.r);
				return current;
			}

			for (int k = 0; k < 4; k++) { // 다음칸 찾기
				int newr = current.r + di[k];
				int newc = current.c + dj[k];

				if (newr >= 0 && newr < N && newc >= 0 && newc < N && !visited[newr][newc] && board[newr][newc] <= size) {
					pq.add(new Node(newr, newc, current.d + 1));
					visited[newr][newc] = true;
				}
			}
		}
		return null;
	}
}
