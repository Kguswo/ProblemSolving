/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] start, end;
	static int[][][][] dp;
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		String e = br.readLine();

		start = new int[103];
		end = new int[103];

		for (int i = 0; i < N; i++) {
			start[i] = s.charAt(i) - '0';
			end[i] = e.charAt(i) - '0';
		}

		dp = new int[101][10][10][10];
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		System.out.println(solve(0, start[0], start[1], start[2]));
		br.close();
	}

	/**
	 * @param currIdx 현재 맞추고 있는 인덱스 (0 ≤ currIdx < N)
	 * @param x       현재 위치(currIdx)에 있는 디스크의 숫자 (0~9)
	 * @param y       다음 위치(currIdx+1)에 있는 디스크의 숫자 (0~9)
	 * @param z       그 다음 위치(currIdx+2)에 있는 디스크의 숫자 (0~9)
	 * @return currIdx부터 끝까지 목표 상태(end[])로 맞추는 데 필요한 최소 조작 횟수
	 *
	 * <ul>
	 *   <li>한 번의 조작에서 최대 세 개 연속 디스크를 같은 방향으로 최대 3칸까지 돌릴 수 있다.</li>
	 *   <li>현재 자리 x를 end[currIdx]에 맞추기 위해 필요한 칸 수를 왼쪽/오른쪽 두 방향으로 모두 고려한다.</li>
	 *   <li>필요한 칸 수를 (x만 돌림, x+y 돌림, x+y+z 돌림)으로 분배하여 최소 조작 횟수를 계산한다.</li>
	 *   <li>dp[currIdx][x][y][z]에 메모이제이션하여 동일 상태의 중복 연산을 방지한다.</li>
	 * </ul>
	 */
	private int solve(int currIdx, int x, int y, int z) {
		if (currIdx == N) return 0;

		if (dp[currIdx][x][y][z] != -1) return dp[currIdx][x][y][z];

		int res = Integer.MAX_VALUE;

		int diff = (end[currIdx] - x + 10) % 10;
		int[] ableDiffs = {diff, 10 - diff}; // {시계방향 회전수, 반시계방향 회전수}

		for (int i = 0; i <= 1; i++) { // x 디스크는 i=0 시계, i=1 반시계
			for (int j = 0; j <= ableDiffs[i]; j++) { // y 디스크는 0~ableDiffs[i] 만큼
				for (int k = 0; k <= j; k++) { // z 디스크는 0~j 만큼
					int next_y = (y + (i == 0 ? j : -j) + 10) % 10;
					int next_z = (z + (i == 0 ? k : -k) + 10) % 10;

					int rot = solve(currIdx + 1, next_y, next_z, start[currIdx + 3]);

					// 최소 돌린횟수 = 세개 나눠서 돌린 횟수 (xyz돌리기 + xy돌리기 + x돌리기)
					rot += (k + 2) / 3 + ((j - k) + 2) / 3 + ((ableDiffs[i] - j) + 2) / 3;
					res = Math.min(res, rot);
				}
			}
		}

		return dp[currIdx][x][y][z] = res;
	}
}