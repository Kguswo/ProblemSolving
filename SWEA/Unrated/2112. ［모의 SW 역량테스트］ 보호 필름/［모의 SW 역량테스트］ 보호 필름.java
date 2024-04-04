import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T, D, W, K;
	static int[] a = { 0, 1 };
	static int[] chooserow;
	static int[][] cell;
	static boolean flag;
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			visited = new boolean[D];
			cell = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					cell[i][j] = sc.nextInt(); // 0 : A, 1 : B
				}
			}

			flag = false;
			if (check(cell)) {
				System.out.printf("%d\n", 0);
			} else {
				for (int i = 1; i <= K; i++) {
					int[] arr = new int[i]; // arr은 i개 만큼 뽑아 넣을 곳.(A혹은 B를 넣음)
					selectdrug(arr, i, 0);
					if (flag) break;
				}
				System.out.println(chooserow.length);
			}
		}
	}

	private static void selectdrug(int[] arr, int n, int cnt) { // A or B 중복순열 ex) ABB BAB BBA
		if (cnt == n) {
			int[][] newcell = new int[D][W];
			change(newcell, arr);
			return;
		}
		for (int i = 0; i < 2; i++) {
			arr[cnt] = i;
			selectdrug(arr, n, cnt + 1);
		}
	}

	private static void change(int[][] newcell, int[] arr) {
		chooserow = new int[arr.length];
		combination(arr, 0, 0); // 0~D중
	}

	private static void combination(int[] arr, int cnt, int start) { // ABB BAB BBA처럼 고른 약물들을 내가 고른 행들에 주입할 것임!
		if (cnt == arr.length) {
			// 고치기전에 cell을 newcell로 복사
			int[][] newcell = new int[D][W];
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					newcell[i][j] = cell[i][j];
				}
			}
			
			for (int x = 0; x < chooserow.length; x++) { // 선택한 행에 선택한 약물 주입!
				for (int j = 0; j < W; j++) {
					newcell[chooserow[x]][j] = arr[x];
				}
			}
			
			if (check(newcell)) flag = true; // newcell 검사했는데 통과했으면 flag true로 바꾸고 다 종료
			return;
		}
		for (int i = start; i < D; i++) {
			chooserow[cnt] = i;
			combination(arr, cnt + 1, i + 1);
			if(flag) return;
		}
	}

	private static boolean check(int[][] newcell) { // 모든 열에서 K개 이상의 연속된 약품이 존재하는가? 존재한다 : true, 아니다 : false
		for (int j = 0; j < W; j++) {
			int count = 1;
			for (int i = 0; i < D - 1; i++) {
				if (newcell[i][j] == newcell[i + 1][j]) {
					count++;
					if (count >= K) break;
				} 
				else count = 1; // A B 다르면 다시 1부터 세기
			}
			if (count < K) return false;
		}
		return true;
	}
}