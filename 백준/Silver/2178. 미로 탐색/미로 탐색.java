import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static int M;
	static int[][] board;
	static boolean[][] visited;
	static int[][] length;
	static int mincount = Integer.MAX_VALUE;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);


		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];
		length = new int[N + 2][M + 2];

		for (int r = 1; r < N + 1; r++) {
			String str = sc.next();
			for (int c = 1; c < M + 1; c++) {
				board[r][c] = str.charAt(c - 1) - '0'; // 내부 값을 입력받음
			}
		}

//		for(int r=0; r<N+2; r++) {
//			for(int c=0; c<M+2; c++) {
//				System.out.print(board[r][c]);
//			}
//			System.out.println();
//		}

		/*
		 * 00000000 01011110 01010100 01010110 01110110 00000000
		 */
//		dfs(1, 1, 1);
//		System.out.println(mincount);
		
		bfs(1,1);
		System.out.println(length[N][M]);
	}

	private static void dfs(int r, int c, int length) {
		// 기저조건 : 목적 지점에 도달 했는가?
		if (r == N && c == M) {
			mincount = Math.min(length, mincount);
			return;
		}
		if (length > mincount)
			return;

		// 이동한 칸은 방문했음을 표시
		visited[r][c] = true;

		// 사방탐색(상, 하, 좌, 우) 가능 루트를 재귀로
		for (int idx = 0; idx <= 3; idx++) {
			int newr = r + dr[idx];
			int newc = c + dc[idx];
			// 이동한 칸이 1이고 and 이동한 칸에 방문한 적이 없다 => 가능한 루트
			if (board[newr][newc] == 1 && visited[newr][newc] == false) {
				dfs(newr, newc, length + 1); // 이동하여 다시 진행
			}
		}
		// 더이상 가능 루트가 없을 때, 다시 이전으로 돌아와서 탐색해야하니까
		visited[r][c] = false;
	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>(); // 퍼져나갈때마다 이전값 빼고 현재값 넣기위해 큐로 구현
		queue.offer(new int[] { r, c });
		/*
		 * 넣을때마다 큐에 4
		 * { {r1, c1}
		 * 	 {r2, c2}
		 *     ...
		 *   {rn, cn} }  
		 */
		visited[r][c] = true; // 방문자리 표시 
		length[r][c] = 1; // 출발점부터 길이 1 시작

		while (queue.isEmpty()==false) {
			int[] current = queue.poll(); // 이전 좌표 ( 각 반복마다 시작할 좌표이기도 함 ) 
			int currentr = current[0];
			int currentc = current[1];

			for (int idx = 0; idx <= 3; idx++) { // 4방탐색
				int newr = currentr + dr[idx];
				int newc = currentc + dc[idx];

				if (board[newr][newc] == 1 && visited[newr][newc] == false) { // 이동 할 조건
					// 이동했으면 필요 작업 : 큐에 이동좌표 넣기, 이동한 좌표 방문표시, 한칸 더 간 것이므로 길이 +1
					queue.offer(new int[] { newr, newc }); // 큐에 내가 이동한 좌표 넣음( 시작할 좌표 빠지고 그거마다 0~3개씩 큐에 추가됨) -> 그 빠지는 칸 마다 또 탐색하니까 bfs가 되는 것
					visited[newr][newc] = true; // 방금 이동한 칸을 방문 칸으로 표시
					length[newr][newc] = length[currentr][currentc] + 1; // 이동좌표의 값을 이전칸 길이 값에서 +1
				}
			}
		}
	}
}