import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int mindistance = Integer.MAX_VALUE;
	static int [][] board;
	static List<int[]> chicken, house;
	static int [][] S;
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 board = new int [N][N];
		 chicken = new ArrayList<>();
		 house = new ArrayList<>();
		 S = new int [M][2];
		 for(int i=0; i<N; i++) {
			 for(int j=0; j<N; j++) {
				 board[i][j] = sc.nextInt();
				 if(board[i][j] == 2)  chicken.add(new int[] {i, j});
				 if(board[i][j] == 1)  house.add(new int[] {i, j});
			 }
		 }
		 combination(0, 0);
		 System.out.println(mindistance);
	}
	private static void combination(int cnt, int start) {
		if(cnt == M) {
			int sumdistance = 0;
			for(int[] h : house) {
				sumdistance += caldistance(h, S);
				if(sumdistance > mindistance) return;
			}
			mindistance = Math.min(sumdistance, mindistance);
			return;
		}
		for(int i=start; i<chicken.size(); i++) {
			S[cnt] = chicken.get(i);
			combination(cnt+1, i+1);
		}
	}
	private static int caldistance(int[] h, int[][] S) { // 최소거리만 채택
		int length = Integer.MAX_VALUE;
		for(int[] selected : S) {
			length = Math.min(length, Math.abs(selected[0] - h[0]) + Math.abs(selected[1]-h[1]));
		}
		return length;
	}
}
