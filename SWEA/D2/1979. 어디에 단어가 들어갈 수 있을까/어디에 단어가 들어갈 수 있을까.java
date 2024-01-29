import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스의 개수 T
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			// 가로, 세로 길이 N
			int N = sc.nextInt();
			// 단어의 길이 K
			int K = sc.nextInt();
			// 2차원 배열
			int[][] arr = new int[N][N];
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					// 0과 1로 채움
					int num = sc.nextInt();
					arr[row][col] = num;
				}
			}

			int ans = 0;

			// 가로검사
			for (int row = 0; row < N; row++) {
				// 길이세기 변수
				int count = 0;
				for (int col = 0; col < N; col++) {
					// 1인곳부터 시작해서 자신포함해서 길이측정
					// count가 K랑 같아야함. 길어도안됨.
					// 0을 만났을때는 무조건 길이검사하고 0부터 다시세야하므로 count초기화 및 ans변경
					
					//행에서 검사해야할 행동
					//밟은 칸이 1이다 -> 길이 1 추가 ->
					//밟은 칸이 0이다 -> 길이추가 멈추고 검사 -> 지금까지 count 가 K와 같은가? -> 같으면 ans++하고 길이 초기화(다시세야하니까)
					//행 검사가 끝나고 count체크해서 K면 ans++
					if (arr[row][col] == 1) {
						count++;
					}
					if (arr[row][col] == 0) {
						if (count == K) {
							ans++;
						}
						count = 0;
					}
				}
				if (count == K) {
					ans++;
				}
			}

			// 세로검사
			for (int col = 0; col < N; col++) {
				// 길이세기 변수
				int count = 0;
				for (int row = 0; row < N; row++) {
					// 1인곳부터 시작해서 자신포함해서 길이측정
					// count가 K랑 같아야함. 길어도안됨.
					// 0을 만났을때는 무조건 길이검사하고 0부터 다시세야하므로 count초기화 및 ans변경
					if (arr[row][col] == 1) {
						count++;
					}
					if (arr[row][col] == 0) {
						if (count == K) {
							ans++;
						}
						count = 0;
					}
				}
				if (count == K) {
					ans++;
				}
			}
			System.out.printf("#%d %d", i + 1, ans);
			System.out.println();
		}
	}
}
