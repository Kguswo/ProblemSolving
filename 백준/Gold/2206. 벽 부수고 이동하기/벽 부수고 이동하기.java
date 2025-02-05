import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] board;
	static boolean[][][] visited;
	static int[][][] length;
	static int mincount = Integer.MAX_VALUE;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2][2];
		length = new int[N + 2][M + 2][2];

		for (int r = 0; r < N + 2; r++) {
			for (int c = 0; c < M + 2; c++) {
				board[r][c] = 1;
			}
		}
		for (int r = 1; r <= N; r++) {
			String str = sc.next();
			for (int c = 1; c <= M; c++) {
				board[r][c] = str.charAt(c - 1) - '0';
			}
		}

		bfs(1, 1);

        if (mincount == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(mincount);
        }
	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c, 1 });

		visited[r][c][1] = true;
		length[r][c][1]= 1;

		while (queue.isEmpty() == false) {
			int[] current = queue.poll();

			int currentr = current[0];
			int currentc = current[1];
			int currentwallbreak = current[2];
			
			//최소길이 갱신
            if (currentr == N && currentc == M) {
                mincount = Math.min(length[currentr][currentc][currentwallbreak], mincount);
            }

			for (int idx = 0; idx <= 3; idx++) {
				int newr = currentr + dr[idx];
				int newc = currentc + dc[idx];
                    if (board[newr][newc] == 0 && visited[newr][newc][currentwallbreak] == false) {
                        queue.add(new int[]{newr, newc, currentwallbreak});
                        visited[newr][newc][currentwallbreak] = true;
                        length[newr][newc][currentwallbreak] = length[currentr][currentc][currentwallbreak] + 1;
                    }
                    else if (newr >= 1 && newr <= N && newc >= 1 && newc <= M && board[newr][newc] == 1 && visited[newr][newc][0]== false && currentwallbreak == 1) {
                        queue.add(new int[]{newr, newc, 0});
                        visited[newr][newc][0] = true;
                        length[newr][newc][0] = length[currentr][currentc][currentwallbreak] + 1;
                    }
			}
		}
	}
}