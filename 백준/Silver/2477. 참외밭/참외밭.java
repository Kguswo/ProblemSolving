import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int largex = 0;
	static int largey = 0;
	static int smallx = 500;
	static int smally = 500;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


		int N = sc.nextInt();
		int dr[] = { 0, 0, 0, -1, +1 };
		int dc[] = { 0, +1, -1, 0, 0 };
		int[][] arr = new int[2][9]; // 방향저장
		int r = 0;
		int c = 0;
		int bigrectangular = 0;
		for (int tc = 0; tc < 6; tc++) {
			int direction = sc.nextInt();
			int length = sc.nextInt();

			if (direction == 1 || direction == 2) {
				if (largex < length)
					largex = length;
			}
			if (direction == 3 || direction == 4) {
				if (largey < length)
					largey = length;
			}
			bigrectangular = largex * largey;

			if (tc == 0) {
				arr[0][0] = direction;
				arr[0][6] = direction;
				arr[1][0] = length;
				arr[1][6] = length;
			}
			else if (tc == 1) {
				arr[0][1] = direction;
				arr[0][7] = direction;
				arr[1][1] = length;
				arr[1][7] = length;
			}
			else if (tc == 2) {
				arr[0][2] = direction;
				arr[0][8] = direction;
				arr[1][2] = length;
				arr[1][8] = length;
			}
			else {
				arr[0][tc] = direction;
				arr[1][tc] = length;	
			}
		}
		
		int smallrectangular=0;
		for (int i = 0; i < 6; i++) {
			if (arr[0][i] == arr[0][i + 2] && arr[0][i + 1] == arr[0][i + 3]) {
				if(arr[0][i + 1] == 1 || arr[0][i + 1] ==2) {
					 smallx = arr[1][i+1];
					 smally = arr[1][i+2];
				}
				else if(arr[0][i + 1] == 3 || arr[0][i + 1] == 4) {
					 smally = arr[1][i+1];
					 smallx = arr[1][i+2];
				}
			}
			else continue;
		}
		smallrectangular = smallx * smally;
		
		System.out.println(N*(bigrectangular-smallrectangular));
	}
}