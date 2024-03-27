import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Integer[] arr, S;
	static int N, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		Arrays.sort(arr, (o1, o2) -> o1 - o2);

		S = new Integer[R];
		permutation(0, 0);
	}

	private static void permutation(int cnt, int start) {
		if (cnt == R) {
			showAns();
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			S[cnt] = arr[i];
			permutation(cnt + 1, i + 1);
		}
	}

	private static void showAns() {
		for (int i = 0; i < S.length; i++) {
			System.out.print(S[i] + " ");
		}
	}
}