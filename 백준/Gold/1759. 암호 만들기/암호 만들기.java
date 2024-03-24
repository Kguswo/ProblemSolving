import java.util.Arrays;
import java.util.Scanner;

class Main {

	public static int L, C;
	public static char str[];
	public static char ans[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();

		C = sc.nextInt();

		str = new char[C];
		ans = new char[L];

		for (int i = 0; i < C; i++) {
			str[i] = sc.next().charAt(0);
		}

		Arrays.sort(str);

		find(0, 0);

	}

	public static void find(int start, int depth) {
		if (depth == L) { // base
			int coCount = 0;
			int voCount = 0;
			for (int i = 0; i < L; i++) {
				if (ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u')
					coCount++;

				else
					voCount++;

				if (coCount >= 1 && voCount >= 2)
					break;
			}

			if (coCount >= 1 && voCount >= 2)

				System.out.println(ans);

			return;
		}

		for (int i = start; i < C; i++) {
			ans[depth] = str[i];
			find(i + 1, depth + 1);
		}

	}
}