import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int [N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = i;
		}
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			reverse(start, end);
		}
		showans(N);
	}

	private static void showans(int N) {
		for(int i=1; i<=N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void reverse(int start, int end) {
        if (arr == null || start < 0 || end >= arr.length || start >= end) {
            return;
        }
        
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
	}
}


