import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
            System.out.printf("#%d \n", tc);
			int n = sc.nextInt();
			int[][] arr = null;
			for (int i = 1; i <= n; i++) {
				arr = new int[n][i];
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
