import java.util.Scanner;

public class Main {
	static int[][] board;
	static boolean[][] visited;
	static int N, M, K, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		board = new int[N + 2][M + 2];
		visited = new boolean[N + 2][M + 2];

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				board[i][j] = sc.nextInt();
			}
		}
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < M + 2; j++) {
                visited[i][j] = false;
            }
        }
		max = Integer.MIN_VALUE;
		pick(K, 0, 1, 1);
		System.out.println(max);
	}

	private static void pick(int k, int sum, int row, int col) {
	    if (k == 0) {
	        max = Math.max(max, sum);
	        return;
	    }

	    for (int i = row; i < N + 1; i++) {
	    	// 같은행부터 시작하면 이전부터하면 안되니까 col부터, 아니면 다음행부터는 1부터
	        for (int j = (i == row) ? col : 1; j < M + 1; j++) { 
	            if (!visited[i][j] && !deltaVisited(i, j)) {
	                visited[i][j] = true;
	                pick(k - 1, sum + board[i][j], i, j);
	                visited[i][j] = false;
	            }
	        }
	    }
	}
    private static boolean deltaVisited(int i, int j) { // 놓을곳 사방에 방문자리 하나라도 있으면 true
        return visited[i - 1][j] || visited[i + 1][j] || visited[i][j - 1] || visited[i][j + 1];
    }

}