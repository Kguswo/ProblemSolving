import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}		
		Arrays.sort(arr);		
		System.out.println(arr[0] * arr[n-1]);
	}
}
