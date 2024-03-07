import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M, num, howlong;
	static int[][] board;
	static int[][] day;
	static boolean[][] visited;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

		M = sc.nextInt();
		N = sc.nextInt();
		board = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];
		day = new int[N + 2][M + 2];
		list = new ArrayList<>();
		howlong = 0;

		for (int r = 0; r < N + 2; r++) {
			for (int c = 0; c < M + 2; c++) {
				board[r][c] = -1;
			}
		}

		for (int r = 1; r < N + 1; r++) {
			for (int c = 1; c < M + 1; c++) {
				num = sc.nextInt();
				board[r][c] = num;
				if (num == 1) {
					list.add(new int[] { r, c });
				}
			}
		}

		bfs(board);		
		if (!find0(board)) { 
            System.out.println(-1);
            return;
        }

		
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                howlong = Math.max(howlong, day[r][c]);
            }
        }
        System.out.println(howlong);
	}

	private static void bfs(int[][] map) {
		Queue<int[]> queue = new LinkedList<int[]>();

		// 큐에 모든 첫 1들 추가
		for (int[] a : list) {
			queue.add(a);
			visited[a[0]][a[1]] = true;
		}

		while (queue.isEmpty() == false) {
			int[] current = queue.poll();
			int currentr = current[0];
			int currentc = current[1];

			for (int idx = 0; idx <= 3; idx++) {
				int newr = currentr + dr[idx];
				int newc = currentc + dc[idx];

				if (map[newr][newc] == 0 && visited[newr][newc] == false) {
					queue.add(new int[] { newr, newc });
					visited[newr][newc] = true;
					day[newr][newc] = day[currentr][currentc] + 1;
				}
			}
		}
	}
    private static boolean find0(int[][] map) {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                if (map[r][c] == 0 && !visited[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
