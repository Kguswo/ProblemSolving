import java.util.Scanner;

public class Main {
	static int digit = 1;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = n;
		while(true) {
			if(n/10 == 0) break;
			n = n/10;
			digit++;
		}
//		System.out.println(digit);
		
		for(int i=1; i<digit; i++) {
			ans += i*((int) Math.pow(10, i) -(int) Math.pow(10, i-1));
//			System.out.println(ans);
		}
		ans += digit*(num+1 - (int) Math.pow(10, digit-1));
		System.out.println(ans);
	}
}
