import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		long sum = 0;
		for(int i=1; i<=N; i++) {
			sum += i*(N/i);
		}
		System.out.println(sum);
	}
}
