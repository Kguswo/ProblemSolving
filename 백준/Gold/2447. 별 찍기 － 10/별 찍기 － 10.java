import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		String[][] arr = new String[N][N];
		
		for (int i = 0; i < N; i++) { // 2차원 배열 모두 *로 채우기
			for (int j = 0; j < N; j++) {
				arr[i][j] = "*";
			}
		}	
		draw(arr, N, 0, 0);
		print(arr,N, sb);	
	}

	public static void draw(String arr[][], int N, int starti, int startj) { // 가운데 공백패턴 만들기

		if (N == 3) { // 최소 사이즈일때.
			arr[starti+1][startj+1] = " "; // 가운데 공백넣기
			return;
		} 
		else {
			int newN = N/3; // 9등분
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1) { // 중간 공백 만들기
						for(int k=starti+newN; k<starti+newN*2; k++) {
							for(int l=startj+newN; l<startj+newN*2; l++) {
								arr[k][l] = " ";
							}
						}
					}
					else { // 나머지 8칸 다시 재귀
						draw(arr ,newN, starti+newN*i, startj+newN*j);
					}
				}
			}
		}
	}
	
	public static void print(String arr[][], int N, StringBuilder sb) { // 2차원배열 그리기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j]);
			}				
			sb.append("\n");
		}
		System.out.println(sb);
	}
}