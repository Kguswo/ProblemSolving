import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int N,K, arr[], ans=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K =sc.nextInt();
		arr = new int [N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
        Arrays.sort(arr);
		for(int i=arr.length-1; i>=0; i--) {
			int count =0;
			count += K / arr[i]; 
			K -= count * arr[i];
			ans += count;
			if(K<=0) break;
		}
		System.out.println(ans);
		
	}
}