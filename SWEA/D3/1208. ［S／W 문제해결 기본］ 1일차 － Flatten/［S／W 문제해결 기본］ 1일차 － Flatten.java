
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		// 10번의 테스트케이스
		for (int tc = 0; tc < 10; tc++) {
			// 가로길이 100의 배열 선언 및 초기화
			int[] arr = new int[100];
			// 덤프 횟수 받아오기
			int dump = sc.nextInt();
			int max = 0;
			int min = 101;

			// 배열에 값을 넣음
			for (int i = 0; i < 100; i++) {
				int num = sc.nextInt();
				arr[i] = num;
				
				// 최댓값 갱신
				if (max < num) {
					max = num;
				}
				
				// 최솟값 갱신
				if (min > num) {
					min = num;
				}
			}

			// 덤프횟수만큼 최댓값최솟값 평탄화 진행
			for (int i = 0; i < dump; i++) {
				
				// 최댓값에 -1, 최솟값에 +1
				for (int j = 0; j < 100; j++) {
					if (arr[j] == max) {
						arr[j]--;
						break;// 가장 첫 최댓값 1개만 -1
					}
				}

				for (int j = 0; j < 100; j++) {
					if (arr[j] == min) {
						arr[j]++;
						break;// 가장 첫 최솟값 1개만 +1
					}
				}
				// 평탄화 1번 끝

				// 이제 최댓값 최솟값이 바뀌었으므로
				// 다시 최대최소 구해서 검사
				max = 0; min = 101;

				for (int j = 0; j < 100; j++) {	
					// 최댓값 갱신
					if (max < arr[j]) {
						max = arr[j];
					}
					
					// 최솟값 갱신
					if (min > arr[j]) {
						min = arr[j];
					}
				}

				//평탄화 후 바뀐 최대 최소값의 차이가 1이하라면 멈춰야함
				if((max-min) <=1) {
					break;
				}
				
			}

			System.out.print("#" + (tc+1) + " " + (max-min));
			System.out.println();
        }
	}
}