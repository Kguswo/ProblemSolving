import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		int N = s.nextInt(); // 지도의 크기
		int L = s.nextInt(); // 경사로의 길이

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = s.nextInt();
			}
		}

		/*
		 * 그냥 간편하게 반복문을 돌면서 차이가 2이면 stop, 차이가 1이지만 L개가 연속되지 않으면 stop
		 */

		int answer = 0;
		// 경사로를 놓은 위치 기록(가로)
		boolean[][] stairsCol = new boolean[N][N];
		// 경사로를 놓은 위치 기록(세로)
		boolean[][] stairsRow = new boolean[N][N];

		// 가로 기준 먼저
		for (int i = 0; i < N; i++) {
			boolean isOk = true;

			// 마지막거는 비교 대상에서 제외
			for (int j = 0; j < N - 1; j++) {
				try {
					// 차이가 없으면 continue
					if (board[i][j] == board[i][j + 1]) {
						continue;
					}
					// 차이가 2 이상이면 break
					else if (Math.abs(board[i][j] - board[i][j + 1]) >= 2) {
						isOk = false;
						break;
					}
					// 차이가 1인데 L 줄 이상 유지되면 continue
					// 만약 L줄 이하면 자동으로 throw됨
					// 오른쪽이 낮을 경우
					else if (board[i][j] - board[i][j + 1] == 1) {
						// L이 1인데 이미 해당 칸에 계단이 있을 경우
						if (L == 1 && stairsCol[i][j + 1]) {
							isOk = false;
							break;
						}

						for (int k = 2; k <= L; k++) {
							if (stairsCol[i][j + k] || board[i][j + 1] != board[i][j + k]) {
								isOk = false;
								break;
							}
						}

						// 다리를 놓았으므로 더 이상 다리를 놓지 못하게 초기화
						for (int k = 1; k <= L; k++) {
							stairsCol[i][j + k] = true;
						}
					} else if (board[i][j] - board[i][j + 1] == -1) {
						// L이 1인데 이미 해당 칸에 계단이 있을 경우
						if (L == 1 && stairsCol[i][j]) {
							isOk = false;
							break;
						}

						for (int k = 1; k < L; k++) {
							if (stairsCol[i][j - k] || board[i][j] != board[i][j - k]) {
								isOk = false;
								break;
							}
						}

						// 다리를 놓았으므로 더 이상 다리를 놓지 못하게 초기화
						for (int k = 1; k < L; k++) {
							stairsCol[i][j - k] = true;
						}
					}
				} catch (Exception e) {
					isOk = false;
					break;
				}
			}

			// 한 번의 for문이 돌 때까지 isOk가 true상태 그대로이면 answer 추가
			if (isOk) {
				answer++;
			}

			// 세로 기준
			isOk = true;

			for (int j = 0; j < N - 1; j++) {
				try {
					// 차이가 없으면 continue
					if (board[j][i] == board[j + 1][i]) {
						continue;
					}
					// 차이가 2 이상이면 break
					else if (Math.abs(board[j][i] - board[j + 1][i]) >= 2) {
						isOk = false;
						break;
					}
					// 차이가 1인데 L 줄 이상 유지되면 continue
					// 만약 L줄 이하면 자동으로 throw됨
					// 오른쪽이 낮을 경우
					else if (board[j][i] - board[j + 1][i] == 1) {
						// L이 1인데 이미 해당 칸에 계단이 있을 경우
						if (L == 1 && stairsRow[j + 1][i]) {
							isOk = false;
							break;
						}

						for (int k = 2; k <= L; k++) {
							if (stairsRow[j + k][i] || board[j + 1][i] != board[j + k][i]) {
								isOk = false;
								break;
							}
						}

						// 다리를 놓았으므로 더 이상 다리를 놓지 못하게 초기화
						for (int k = 1; k <= L; k++) {
							stairsRow[j + k][i] = true;
						}
					} else if (board[j][i] - board[j + 1][i] == -1) {
						// L이 1인데 이미 해당 칸에 계단이 있을 경우
						if (L == 1 && stairsRow[j][i]) {
							isOk = false;
							break;
						}

						for (int k = 1; k < L; k++) {
							if (stairsRow[j - k][i] || board[j][i] != board[j - k][i]) {
								isOk = false;
								break;
							}
						}

						// 다리를 놓았으므로 더 이상 다리를 놓지 못하게 초기화
						for (int k = 1; k < L; k++) {
							stairsRow[j - k][i] = true;
						}
					}
				} catch (Exception e) {
					isOk = false;
					break;
				}
			}

			// 한 번의 for문이 돌 때까지 isOk가 true상태 그대로이면 answer 추가
			if (isOk) {
				answer++;
			}
		}

		System.out.println(answer);

	}

}