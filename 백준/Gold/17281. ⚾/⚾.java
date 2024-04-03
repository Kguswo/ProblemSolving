import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int inning, order[], makeorder[], max;
	static int[][] board;
	static boolean[] visited;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		inning = sc.nextInt();
		visited = new boolean[9];
		order = new int[9]; // XXX0XXXXX넣을곳
		board = new int[inning][9];
		for(int i=0; i<inning; i++) {
			for(int j=0; j<9; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		order[3] = 0; visited[3] = true; // 4번째 타자 고정
		permutation(1);
		System.out.println(max);
	}
	static int idx=1;
	private static void permutation(int cnt) {
		if(cnt == 9) {
//			System.out.println(Arrays.toString(order) + " " + (idx++) + "번째");
//			swap();
//			calmaxscore(order, 0, 0, 0, 0);
			max = Math.max(max, calmaxscore());
//			System.out.println(max);
			return;
		}		
		for(int i=0; i<=8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[i] = cnt;
				permutation(cnt +1);
				visited[i] = false;
			}
		}
	}
	private static void swap() {
		int tmp = order[3];
	    order[3] = order[0];
		order[0] = tmp;
	}
	private static int calmaxscore() {
		int sum = 0, index = 0;
		for(int i=0; i<inning; i++) {
			int outcount = 0;
			int [] base = new int [3];
			
			while(outcount <3) {
				if(board[i][order[index]]==0) outcount++;
				else { // 치긴 쳤으면
					//먼저 1,2,3루 애들 이동
					for (int j = 2; j >= 0; j--) {
	                    if (base[j] > 0) {
	                        if (j + board[i][order[index]] >= 3) { // 점수 낼떄
	                            sum++;
	                            base[j] = 0;
	                        } else { // 나머지 경우는 이동
	                            base[j + board[i][order[index]]] = 1;
	                            base[j] = 0;
	                        }
	                    }
	                }
					// 타자이동
					// 0과 4 아니면 일단 쳤으므로 친 만큼 이동
					if(board[i][order[index]] != 4) base[board[i][order[index]]-1] = 1;
					else {
						sum += 1 + base[0] + base[1] + base[2];
			            Arrays.fill(base, 0); // 홈런이므로 다시 베이스 비우기
					}
				}
				index = (index + 1) % 9;
//				System.out.println("인덱스 : " + index);
			}
		}
		return sum;
	}
}