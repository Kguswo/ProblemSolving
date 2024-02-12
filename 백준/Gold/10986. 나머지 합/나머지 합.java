
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		long[] arr = new long[N];
		long[] count = new long[M];
		long ans = 0;
		
		arr[0] = sc.nextInt();
		for (int i = 1; i < N; i++) {
			int num = sc.nextInt();
			arr[i] = arr[i - 1] + num;
		}
		for (int i = 0; i < N; i++) {
			int mod = (int)(arr[i] % M);
			if(mod == 0) {
				ans ++;
			}
			count[mod]++;
		}
		for(int i=0; i<M; i++) {
			if(count[i]>1) {
				ans = ans + ((count[i]*(count[i]-1)))/2;
			}
		}
		System.out.println(ans);
	}
}
