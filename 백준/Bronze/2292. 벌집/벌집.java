import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < 40000; i++) {
			if (num >= 2 + (6 * (i - 2) * (i - 1) / 2) && num <= 1 + (6 * (i - 1) * i / 2)) {
				System.out.println(i);
				break;
			}
			else if (num == 1) {
				System.out.println(1);
				break;
				}
		}
	}
}