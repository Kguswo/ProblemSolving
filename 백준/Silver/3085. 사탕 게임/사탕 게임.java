import java.util.Scanner;

public class Main {
	static int N, ans, maxLength, currentLength;
	static char[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		board = new char[N][N];
		ans = 0;
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<N; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		//상하
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] != board[i+1][j]) {
					changeUpDownAndGetMax(i, j);
				}
			}
		}	
		//좌우
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(board[i][j] != board[i][j+1]) {
					changeLeftRightAndGetMax(i, j);
				}
			}
		}	
		System.out.println(ans);
	}
	
	private static void changeUpDownAndGetMax(int i, int j) {
		int newi = i+1;
		swap(i, j, newi, j);
		getMaxLength();
		swap(i, j, newi, j);
	}
	private static void changeLeftRightAndGetMax(int i, int j) {
		int newj = j+1;
		swap(i, j, i, newj);
		getMaxLength();
		swap(i, j, i, newj);
	}
	
	public static void swap(int r1, int c1, int r2, int c2) {
        char tmp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = tmp;
    }
	
	private static void getMaxLength() {
		maxLength = 0;
		currentLength = 0;
		
		//가로계산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == 0 || board[i][j] != board[i][j - 1]) {
					currentLength = 1;
				} else {
					currentLength++;
				}
				maxLength = Math.max(maxLength, currentLength);
			}
			currentLength = 0; // 초기화
		}
		//세로계산
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (i == 0 || board[i][j] != board[i - 1][j]) {
					currentLength = 1;
				} else {
					currentLength++;
				}
				maxLength = Math.max(maxLength, currentLength);
			}
			currentLength = 0; // 초기화
		}
		ans = Math.max(ans, maxLength);		
	}
	
}
