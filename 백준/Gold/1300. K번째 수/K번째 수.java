/*
 3x3
 1 2 3
 2 4 6
 3 6 9
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int idx = 0;
		System.out.println(search(1, K));
	}
	
	static long search(long low, long high) {
		while(true) {
			if(low>=high) break;
			
			long mid = (low+high)/2;
			long Ncount = countsum(mid);
			
			if(K<=Ncount) high = mid;
			else low = mid +1;
		}
		return low;
	}

	private static long countsum(long mid) {
		long Ncount = 0;
		for(int i=1; i<=N; i++) {
			if(mid/i >N) Ncount += N;
			else Ncount += mid/i;
//			System.out.println(mid/i);
		}
		return Ncount;
	}
}