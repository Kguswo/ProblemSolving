import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N + 1];
		int count = 0;
		int idx = 1;
		boolean flag = false;
		arr[1] = 1;
		while (true) {
			for (int i : arr) {
				if (i == M)
					flag = true;
			}
			if (flag)
				break;
			// 값 올리기
			// 인덱스 변경
			if (arr[idx] % 2 != 0) {
				idx = (idx + L)%N;
				if (idx == 0) idx = N;
				count++;
			}
			else {
				if (idx - L <= 0) {
					idx = idx + N - L;
				}
				else idx = idx - L;
				count++;
			}
			arr[idx] += 1;
		}
		System.out.println(count);
	}
}