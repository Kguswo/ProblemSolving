import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, S, count;
	static int[] arr, addarr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int n=1; n<=N; n++) {
			addarr = new int [n];
			combination(n, 0, 0);
		}
		System.out.println(count);
	}
	private static void combination(int n, int cnt, int start) {
		if(cnt == n) {
			int sum=0;
			for(int i : addarr) sum+=i;
			if(sum == S) count++;
			return;
		}
		for(int i=start; i<N; i++) {
			addarr[cnt] = arr[i];
			combination(n, cnt+1, i +1);
		}
	}
}
