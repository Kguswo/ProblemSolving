import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextInt();
		String str = sc.next();
		long sum = 0;
        long r = 1;
		for(int i=0; i<N; i++) {
			sum += ((str.charAt(i)-'a'+1)*r)%1234567891;
            r = (r*31)%1234567891;
		}
		System.out.println(sum%1234567891);
	}
}
