import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N, i, j, count, idx, start;
	static int[][] nums;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

		N = sc.nextInt();
		nums = new int[N][2];
		for (int n = 0; n < N; n++) {
			for (int i = 0; i < 2; i++) {
				nums[n][i] = sc.nextInt();
			}
		}
		Arrays.sort(nums, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		count = 0;
		start = 0;
		idx = 0;
		while (idx<N) {
//        	System.out.println("비교할 숫자 : " + nums[start][1] + " vs " + nums[idx+1][0]);
			if (start <= nums[idx][0]) {
				start=nums[idx][1];
				count++;
			}
			idx++;
//        	System.out.println("지금 인덱스 : " + idx + " 지금까지 개수 : " + count);
		}
		System.out.println(count);
	}
}