import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] ans =  new int[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			if(n==0) break;
			int [] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			combination(arr,0,0);
   			System.out.println();
		}
	}
	private static void combination(int[] arr, int start, int depth) {
		if(depth==6) {
			showans(ans);
			System.out.println();
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			ans[depth] = arr[i];
			combination(arr, i+1, depth+1);
		}
	}
	private static void showans(int[] ans2) {
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans2[i] + " ");
		}
	}
}
