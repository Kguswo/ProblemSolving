import java.util.Scanner;

public class Main {
	static int N, currentsum, maxsum;
	static int[] arr, sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		sum = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		currentsum = arr[0];
		maxsum = arr[1];

		for(int i=1; i<=N; i++) {
			currentsum = Math.max(arr[i], currentsum+arr[i]);
			maxsum = Math.max(maxsum, currentsum);
		}
		System.out.println(maxsum);
	}
}
