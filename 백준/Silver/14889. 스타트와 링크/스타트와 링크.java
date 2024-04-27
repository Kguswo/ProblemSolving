import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, board[][], arr1[], arr2[], min = Integer.MAX_VALUE;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		arr1 = new int[N / 2];
		arr2 = new int[N / 2];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		combination(0, 0);
		System.out.println(min);
	}

	private static void combination(int cnt, int start) {
		
		if (cnt == N / 2) {
			calMin();
			return;
		}
		for (int i = start; i < N; i++) {
			visited[i] = true;
			combination(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	private static void calMin() {
		int sum1 = 0; int sum2 = 0;
		int idx1 = 0; int idx2 = 0;
		for (int i = 0; i < N; i++) {
			if(visited[i]) arr1[idx1++] = i;
			else arr2[idx2++] = i;
		}
		for(int a : arr1) {
			for(int b : arr1) {
				sum1 += board[a][b];
			}
		}
		for(int a : arr2) {
			for(int b : arr2) {
				sum2 += board[a][b];
			}
		}
		min = Math.min(min, Math.abs(sum1-sum2));
	}
}