import java.util.Scanner;

public class Main {
	static long N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		long ans = N;
		for(long i=2; i<= Math.sqrt(N); i++) {
			if(N%i == 0) {
				ans -= ans/i;
				while(N%i==0) {
					N /= i;
				}
			}
		}
		if(N > 1) ans=ans-ans/N;
		System.out.println(ans);
	}
}
