import java.util.Scanner;

public class Main {
    private static int N;
    private static int count = 0;
    private static int[] usedj; //  사용된 열(놓을 수 없는 열) 모음
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	usedj = new int[N];
    	NQueen(0);
    	System.out.println(count);
    }

    private static void NQueen(int r) {
        if (r == N) {
            count++;
            return;
        }
        
        for (int c = 0; c < N; c++) {
            if (puttable(r, c)) {
            	usedj[r] = c; // r행 c열에 퀸 배치
                NQueen(r + 1);
            }
        }
    }

    private static boolean puttable(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (usedj[i] == c || usedj[i] - i == c - r || usedj[i] + i == c + r) return false;
        }
        return true;
    }
}
