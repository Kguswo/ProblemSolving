import java.util.Scanner;

public class Main {
	static int starti;
	static int startj;
	static int count[] = new int[3]; // -1 0 1 카운트배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 사이즈
		int paper[][] = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}

		slicepaper(paper, N, starti, startj);
		for (int i = 0; i <= 2; i++) {
			System.out.println(count[i]);
		}
	}

	public static boolean checkPaper(int arr[][], int N, int starti, int startj) { // NxN 모두 같은지 검사
		for (int r = starti; r < starti + N; r++) {
			for (int c = startj; c < startj + N; c++) {
				if (arr[r][c] != arr[starti][startj]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void slicepaper(int arr[][], int N, int starti, int startj) {
		if (checkPaper(arr, N, starti, startj)) {
			count[arr[starti][startj] + 1]++;
		} 
		else {
			int nextN = N / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					slicepaper(arr, nextN, starti + nextN * i, startj + nextN * j);
				}
			}
		}
	}
}
