import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] newarr;
	static boolean flag = false;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		arr = new int[9];
		newarr = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		combination(0, 0, 0, 0);

	}
	static void combination(int idx, int sidx, int sum, int count) { // 조합만들기
		if (flag)
			return;
		if (sidx >= 7) {
			int newarrsum = newarrsum();
			if (newarrsum == 100) {
				flag = true;
				Arrays.sort(newarr);
				for (int i : newarr) {
					System.out.println(i);
				}
			}
			return;
		}
		if (idx >= 9)
			return;

		newarr[sidx] = arr[idx];
		combination(idx + 1, sidx + 1, sum + arr[idx], 0); // 골랐다.
		combination(idx + 1, sidx, sum, 0); // 안 골랐다.
	}
	static int newarrsum() { // 조합의 합
		int sum = 0;
		for (int i = 0; i < newarr.length; i++) {
			sum += newarr[i];
		}
		return sum;
	}
}