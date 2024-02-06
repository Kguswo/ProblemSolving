import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}
		for(int i=0; i<N; i++) {
			int minIdx = i;
			for(int j=i; j<N; j++) {
				if(arr[minIdx]>arr[j]) {
					minIdx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
		int sum=0;
//		System.out.println(Arrays.toString(arr));

		for(int i=1; i<N; i++) {
			arr[i] += arr[i-1];
		}
//		System.out.println(Arrays.toString(arr));
		for(int i=0; i<N; i++) {
			sum += arr[i];
		}
		System.out.println(sum);

	}
}
