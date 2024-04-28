import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long m = scanner.nextLong();
		long n = scanner.nextLong();

		StringBuilder sb = new StringBuilder();
		if (m > n) sb.append(((n - 1) * 2 + 1)); 
		else sb.append(((m - 1) * 2));
		System.out.println(sb.toString());
	}
}
