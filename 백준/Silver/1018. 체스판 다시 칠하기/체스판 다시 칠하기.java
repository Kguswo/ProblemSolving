import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

//		File file = new File("src/input.txt");
//		Scanner sc = new Scanner(file);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		String[] board = new String[N];
		for (int i = 0; i < N; i++) {
			String color = sc.nextLine();
				board[i]= color;
			}

		int min = Integer.MAX_VALUE;

		// 8x8 크기로 탐색
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int count = change(board, i, j);
				if (min > count) {
					min = count;
				}
			}
		}

		System.out.println(min);

		sc.close();
	}

	public static int change(String[] board, int startRow, int startCol) {
		String[] ansboard = {"WBWBWBWB", "BWBWBWBW"};
		int count = 0;
		for (int i = 0; i < 8; i++) {
			int row = startRow + i;
			for (int j = 0; j <  8; j++) {
				int col = startCol + j;
				if(board[row].charAt(col) != ansboard[row%2].charAt(j)) {
					count ++;
				}
			}
		}

		return Math.min(count, 64 - count);
	}
}
