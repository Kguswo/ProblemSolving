import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T, N;
	static long arr[] = new long[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		for (int i = 1; i <= 1000000; i++) {
			for (int j = 1; i * j <= 1000000; j++) {
				arr[i * j] += i;
			}
		}
		for (int i = 1; i <= 1000000; i++) {
			arr[i] += arr[i - 1];
		}

		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			sb.append(arr[N]).append("\n");
		}
		System.out.println(sb);
	}
}