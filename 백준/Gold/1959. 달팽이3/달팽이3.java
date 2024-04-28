import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long m = scanner.nextLong();
		long n = scanner.nextLong();

		StringBuilder sb = new StringBuilder();
		if (m > n) sb.append(((n - 1) * 2 + 1)); 
		else sb.append(((m - 1) * 2));
		sb.append("\n");
		if (m == n) {
			if (m % 2 == 1) sb.append((m / 2 + 1) + " " + (n / 2 + 1));
			else sb.append((m / 2 + 1) + " " + (n / 2));
		} else if (m > n) {
			if (n % 2 == 0) sb.append((n / 2 + 1) + " " + (n / 2));
			else sb.append((n / 2 + 1 + (m - n)) + " " + (n / 2 + 1));
		} else {
			if (m % 2 == 0) sb.append((m / 2 + 1) + " " + (m / 2));
			else sb.append((m / 2 + 1) + " " + (m / 2 + 1 + (n - m)));
		}
		System.out.println(sb.toString());
	}
}
