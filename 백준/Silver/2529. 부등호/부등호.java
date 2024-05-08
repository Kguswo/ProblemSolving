
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static long max = Long.MIN_VALUE, min = Long.MAX_VALUE;
	static String str = "";

	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
//		System.out.println(N);
		for (int i = 0; i < N; i++) {
			str += sc.next();
		}
//		System.out.println(str);
		int[] arr = new int[N + 1];
		boolean[] visited = new boolean[10];
		permutation(0, arr, visited);
		System.out.println(max);
		if (String.valueOf(min).length() < (N + 1)) {
			String minstr = Integer.toString((int) min);
			System.out.println("0"+minstr);
		} else {
			System.out.println(min);
		}
	}

	private static void permutation(int cnt, int[] arr, boolean[] visited) {
		if (cnt == N + 1) {
//			System.out.println(Arrays.toString(arr));
			if (check(arr)) {
//				System.out.println(Arrays.toString(arr));
//				System.out.println("변환"  + numstr(arr));
				min = Math.min(min, numstr(arr));
				max = Math.max(max, numstr(arr));
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[cnt] = i;
				permutation(cnt + 1, arr, visited);
				visited[i] = false;
			}
		}
	}

	private static long numstr(int[] arr) {
	    long num=0;
		for (int i = arr.length - 1; i >= 0; i--) {
			num += Math.pow(10, arr.length - 1 -i) * arr[i];
		}
//		System.out.println("num" + num);
	    return num;
	}

	private static boolean check(int[] arr) {
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == '>') {
				if (arr[i] < arr[i + 1]) {
					flag = false;
					break;
				}
			} else {
				if (arr[i] > arr[i + 1]) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
}