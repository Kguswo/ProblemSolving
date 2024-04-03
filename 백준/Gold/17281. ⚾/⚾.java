import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int inning, order[], board[][], max, base[];
	static boolean[] visited = new boolean[9];
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		
		inning = sc.nextInt();
		board = new int[inning][9];
		for(int i=0; i<inning; i++) {
			for(int j=0; j<9; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		order = new int [9]; order[3] = 0; visited[3] = true; // 1번타자 4고정
		permutation(1);
		System.out.println(max);
	}
	static int idx = 1;
	private static void permutation(int cnt) {
		if(cnt == 9) {
//			System.out.println(Arrays.toString(order) + " " + idx++);
			max = Math.max(calmaxscore(), max);
			return;
		}
		for(int i=0; i<9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[i] = cnt;
//				System.out.println("넣은 값 : " +cnt);
				permutation(cnt+1);
				visited[i] = false;
			}
		}
	}
	private static int calmaxscore() {
		int sum = 0; int index = 0;
		for(int i=0; i<inning; i++) {
			base = new int [5];
			while(base[0] < 3) {
				baseball(base, board[i][order[index]]);
				if(index==8) {
					index=0;
				}else {
					index++;
				}
//				index = (index+1)%9;
//				System.out.println("인덱스 : " + index);
			}
//			System.out.println(Arrays.toString(base));
			sum += base[4];
		}
		return sum;
	}
	private static void baseball(int[] location, int score) {
		for(int i=0; i<score; i++) { // 0, 1, 2, 3만큼 이동
			location[4]+=location[3]; // 여기 점수 낸 사람 수만큼 쌓임 (이닝당 버는 점수)
			location[3]=location[2];
			location[2]=location[1];
			location[1]=0;		
		}
		location[score] += 1;
	}
}