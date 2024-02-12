import java.util.Scanner;

public class Main {
	static int N;
	static int starti;
	static int startj;
	static int count[] = new int[3]; // -1 0 1 카운트배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 사이즈
		int paper[][] = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}
		slicePaper(paper, N, starti, startj);
		for (int i = 0; i <= 2; i++) {
			System.out.println(count[i]);
		}
	}

	public static boolean checkPaper(int arr[][], int N, int starti, int startj) { // 자른 NxN 모두 같은지 검사
		for (int r = starti; r < starti + N; r++) {
			for (int c = startj; c < startj + N; c++) {
				if (arr[r][c] != arr[starti][startj]) {
					return false;
				}
			}
		}
		return true;
	}

	// 검사결과가 true -> 카운팅배열 ++
	// 검사결과가 false -> 자르기
	public static void slicePaper(int arr[][], int N, int starti, int startj) { // checkPaper결과를 바탕으로 재귀형식으로 진행
		if (checkPaper(arr, N, starti, startj)) { // 자른NxN 모두같으면 그 숫자 count ++
			count[arr[starti][startj] + 1]++;
		} 
		else {
			int nextN = N / 3; // 9등분하기위해 변의길이 /3으로 갱신하고자 선언
			// 재귀를 기존 NxN에서 N/3 x N/3 으로 9번 돌려야함
			// 기준점 옮기면서 N/3 x N/3 만큼
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					slicePaper(arr, nextN, starti + nextN * i, startj + nextN * j);
				}
			}
		}
	}
}
