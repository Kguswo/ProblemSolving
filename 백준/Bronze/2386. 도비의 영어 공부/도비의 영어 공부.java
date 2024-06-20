import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String N = sc.nextLine();
			if (N.equals("#"))
				System.exit(0);
			String s[] = N.toLowerCase().split("");

			int count = 0;
			for (int i = 0; i < s.length; i++) {
				if (N.split(" ")[0].equals(s[i]))
					count++;
			}
			System.out.println(N.split(" ")[0] + " " + (count - 1));
		}
	}
}