import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		int N = sc.nextInt();
		long [] arr = new long [K];
		long sum = 0;
		for(int i=0; i<K; i++) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		long high = arr[K-1];
		long low = 1;

        System.out.println(binarySearch(arr, N, low, high));

	}
	static long binarySearch(long[] arr, int target, long start, long end) {
	    long ans = 0;
        
	    while (start <= end) {
		    long count = 0;
		    long mid = ((start + end) / 2);
		    
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid; // mid 길이로 잘랐을 때 몇 개의 랜선이 나오는지 계산
            }
            if(target == 1) return end;
//	        if (target == count) {
//	            return mid;
//	        }
	        if (count < target) {
//	        	ans = Math.max(ans, mid);
	        	end = mid - 1;
	        }else if (target <= count) {
//	        	ans = Math.max(ans, mid);
	        	start = mid + 1;
	        }
	    }
		return start-1;
	}
}
