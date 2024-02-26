
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int H;
	static int W;
	static int N;
	static int k;
	static char[][] arr = new char[H][W];
	static char[] cmd = new char[N];

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			arr = new char[H][W];
			int curri = 0;
			int currj = 0;

			for (int r = 0; r < H; r++) {
				String str = sc.next();
				for (int c = 0; c < W; c++) {
					arr[r][c] = str.charAt(c);
					if (arr[r][c] == '^' || arr[r][c] == 'v' || arr[r][c] == '<' || arr[r][c] == '>') {
						curri = r;
						currj = c;
					}
				}
			}
			N = sc.nextInt();
			cmd = new char[N];
			String command = sc.next();
			for (int i = 0; i < N; i++) {
				cmd[i] = command.charAt(i);
			}
			int dr[] = { -1, 1, 0, 0 };
			int dc[] = { 0, 0, -1, 1 };
			if (arr[curri][currj] == '^')
				k = 0;
			else if (arr[curri][currj] == 'v')
				k = 1;
			else if (arr[curri][currj] == '<')
				k = 2;
			else
				k = 3;
			for (int i = 0; i < N; i++) {
				switch (cmd[i]) {
				case 'U':
					arr[curri][currj] = '^';
					k = 0;
					if(0 > curri-1) continue;
					if (curri != 0 && arr[curri - 1][currj] == '.') {
						arr[curri][currj] = '.';
						arr[curri - 1][currj] = '^';
						curri += dr[k];
						currj += dc[k];
					}
					break;
				case 'D':
					arr[curri][currj] = 'v';
					k = 1;
					if(curri+1 >= H ) continue;
					if (curri != H - 1 && arr[curri + 1][currj] == '.') {
						arr[curri][currj] = '.';
						arr[curri + 1][currj] = 'v';
						curri += dr[k];
						currj += dc[k];
					}
					break;
				case 'L':
					arr[curri][currj] = '<';
					k = 2;
					if(0 > currj-1) continue;
					if (currj != 0 && arr[curri][currj - 1] == '.') {
						arr[curri][currj] = '.';
						arr[curri][currj - 1] = '<';
						curri += dr[k];
						currj += dc[k];
					}
					break;
				case 'R':
					arr[curri][currj] = '>';
					k = 3;
					if(currj+1 >= W) continue;
					if (currj+1 < W && arr[curri][currj + 1] == '.') {
						arr[curri][currj] = '.';
						arr[curri][currj + 1] = '>';
						curri += dr[k];
						currj += dc[k];
					}
					break;
				case 'S':
					// 다음칸으로 쏨
					int si = curri + dr[k];
					int sj = currj + dc[k];
					if (0 > si || si >= H || 0 > sj || sj >= W) { // 경계조건 밖이면 멈춤
						break;
					}
					shoot: while (true) { // 벽을 만나면 여기로 다시 와서 진행
						if (0 > si || si >= H || 0 > sj || sj >= W) { // 경계조건 밖이면 멈춤
							break;
						}
						// 대포가 간 칸에 벽돌벽이면 부수고 사라짐 -> 평지로만듬
						if (0 <= si && si < H && 0 <= sj && sj < W && arr[si][sj] == '*') {
							arr[si][sj] = '.';
							break;

						}
						// 철벽 만나면 멈춤
						else if (0 <= si && si < H && 0 <= sj && sj < W && arr[si][sj] == '#') {
							break;
						} else { // 평지나 바다 쭉 진행
							si += dr[k];
							sj += dc[k];
						}
					}
					break;
				}
			} // N개의 커맨드 모두 수행
			System.out.printf("#%d ", tc);
			for (int r = 0; r < H; r++) { // 결과 arr
				for (int c = 0; c < W; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
		}
	}
}
