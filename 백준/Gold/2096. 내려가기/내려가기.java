import java.util.Scanner;

public class Main {
	static int N;
	static int board[][], maxdp[][], mindp[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new int [N][3];
		maxdp = new int [N+1][3];
		mindp = new int [N+1][3];
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				maxdp[i][0] = board[i-1][0] + Math.max(maxdp[i-1][0], maxdp[i-1][1]);
				maxdp[i][1] = board[i-1][1] + Math.max(maxdp[i-1][0], Math.max(maxdp[i-1][1], maxdp[i-1][2]));
				maxdp[i][2] = board[i-1][2] + Math.max(maxdp[i-1][1], maxdp[i-1][2]);
				mindp[i][0] = board[i-1][0] + Math.min(mindp[i-1][0], mindp[i-1][1]);
				mindp[i][1] = board[i-1][1] + Math.min(mindp[i-1][0], Math.min(mindp[i-1][1], mindp[i-1][2]));
				mindp[i][2] = board[i-1][2] + Math.min(mindp[i-1][1], mindp[i-1][2]);
			}
		}
		System.out.print(Math.max(maxdp[N][0], Math.max(maxdp[N][1], maxdp[N][2])) + " ");
		System.out.println(Math.min(mindp[N][0], Math.min(mindp[N][1], mindp[N][2])));
	}
}