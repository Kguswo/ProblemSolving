import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long N, arr[], k[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new long[10];
		String str = String.valueOf(N);
		int digit = str.length(); // N의 자릿수
		k = new long[10];
		for(int i=0; i<k.length; i++) {
			k[i] = (int) Math.pow(10, i);
		}
//		System.out.println(Arrays.toString(k));
		for (int num = 0; num <= 9; num++) {
			for (int k = 0; k <= digit; k++) {
				arr[num] += find(k, num);
			}
		}
//		System.out.println(Arrays.toString(arr));
		for(int i=0; i<arr.length; i++	) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int find(long k, long targetnum) {
		int count = 0;
		
		long a = (N /(int) Math.pow(10, k+1));
		if(targetnum == 0 && a == 0) { // 자릿수 더 큰데 0 찾으면 000쌓인거 찾는거니까 없애야함
			return 0;
		}
		count += a*Math.pow(10, k);
		
		long b = (N /(int) Math.pow(10, k)) % 10;
		if(b > targetnum) count += Math.pow(10, k);
		else if (b == targetnum) count += N% Math.pow(10, k) + 1;
		
		if(targetnum==0) count -= Math.pow(10, k);
		
		return count;
	}
}