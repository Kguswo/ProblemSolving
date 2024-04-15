import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static String arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new String[N];
		long[] ans = new long [N];

		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			long num = 0;
			for (int j = 0; j < tmp.length(); j++) {
				num += (tmp.charAt(j)-'0')*Math.pow(10, j);
			}
			ans[i] = num;
		}
		Arrays.sort(ans);
		for(long a : ans) {
			System.out.println(a);
		}
	}
}