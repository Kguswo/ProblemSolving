import java.util.Scanner;

public class Main {
	static int[] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		D = new int[N+1];
		for(int i=0; i<=N; i++) {
			D[i] = -1;
		}// 모두 -1로 초기화
		D[0] = 0;
		D[1] = 1;
		fibo(N);
		System.out.println(D[N]);
	}
	private static int fibo(int n) { // top-down
		if(D[n] != -1) return D[n];
		return D[n] = fibo(n-2) + fibo(n-1);
	}
}
