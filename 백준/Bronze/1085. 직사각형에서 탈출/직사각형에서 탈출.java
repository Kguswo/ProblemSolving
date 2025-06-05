
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = Integer.MAX_VALUE;
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		min = Math.min(min, x);
		min = Math.min(min, w-x);
		min = Math.min(min, y);
		min = Math.min(min, h-y);
		System.out.println(min);
	}
}
