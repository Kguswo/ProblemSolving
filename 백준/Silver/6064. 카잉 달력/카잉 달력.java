import java.util.Scanner;

public class Main {
	static int T, M, N, x, y, d, m, count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			m = 1;
			d = 1;
			count = 1;
			boolean found = false;
			int finish = 0;

			while (true) {
				if (m == x)
					break;
				m = (m) % M + 1;
				d = (d) % N + 1;
				count++;
				finish = d;
			}
			if (d != y) {
				for (int i = 0; i < N; i++) {
					d = (d + M - 1) % N + 1;
					count += M;
					if (d == y) {
						found = true;
						break;
					}
				}
				if (!found)
					count = -1;
			}
			System.out.println(count);
		}
	}
}