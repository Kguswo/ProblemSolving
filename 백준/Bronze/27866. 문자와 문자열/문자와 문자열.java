import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int N = sc.nextInt();
		System.out.println(str.charAt(N-1));
	}
}
