import java.util.Scanner;

public class Solution {
	static int p1;
	static int p2;
	static int count=0;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int N = sc.nextInt(); // 세로길이
			int M = sc.nextInt(); // 가로길이
			char arr[][] = new char[N][M];
			min = Integer.MAX_VALUE;
			for(int r=0; r<N; r++) {
				String str = sc.next();
				for(int c=0; c<M; c++) {
					arr[r][c] = str.charAt(c);
				}
			}// 배열 완성
			for(p1=1; p1<N-1; p1++) { // 포인터 1 정하기
				for(p2 = p1+1;p2 < N; p2++) { // 포인터 2 정하기
					// 배열 순회
					for(int r=0; r<N; r++) {
						for(int c=0; c<M; c++) {
							// 각 조건에서 count 증가
							if(r<p1 && arr[r][c] !='W') count++;
							if(r>=p1&&r<p2 && arr[r][c] !='B') count ++;
							if(r>=p2 && arr[r][c] !='R') count ++;
						}
					}
					min = Math.min(min, count); // 최솟값 갱신
					count = 0;
				}
			}
			System.out.printf("#%d %d\n", tc, min);
		}
	}
}
