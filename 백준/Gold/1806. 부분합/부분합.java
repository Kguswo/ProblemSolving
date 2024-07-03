import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, R, N, S, len=Integer.MAX_VALUE;
	static int[] arr;
	static boolean flag = false;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		L = 0; R = L;
		int sum = arr[L];
		while(R < N) {
			if(sum >= S) {
				flag = true;
				len = Math.min(len, R-L+1);
//				System.out.println(L + "~" + R + " / 합 : " + sum + "/ len : " + len);
				sum -= arr[L++];
			}
			else {
				if(R == N-1) break;
//				System.out.println(L + "~" + R + " / 합 : " + sum + "/ len : " + len);
				sum += arr[++R];
			}
		}

		len = flag? len:0;
		System.out.println(len);
	}
}
