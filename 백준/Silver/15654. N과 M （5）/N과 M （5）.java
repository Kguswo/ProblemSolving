import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Integer [] arr, S;
	static int N, R;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr, (o1, o2) -> o1 - o2);

		S = new Integer[R];
		visited = new boolean[N];
		permutation(0);
	}

	private static void permutation(int cnt) {
		if(cnt == R) {
			showAns();
			System.out.println();
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				S[cnt] = arr[i];
				permutation(cnt + 1);
				visited[i] = false;				
			}
		}
	}
	private static void showAns() {
		for(int i=0; i<S.length; i++) {
			System.out.print(S[i] + " ");
		}
	}
}