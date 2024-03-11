import java.util.Scanner;

public class Main {
	static int [] arr, sum;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int [N+1];
		sum = new int [N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
        
		sum[0] = 0;
		if(N>0) sum[1] = arr[1];
		if(N>1) sum[2] = arr[1] + arr[2];

		for(int i=3; i<=N; i++) {
			sum[i] = sum[i-1] + arr[i];
			int jump1 = sum[i-2] + arr[i];
			int jump2 = sum[i-3] + arr[i-1] + arr[i];
			
			if(jump1>jump2) sum[i] = jump1;
			else sum[i] = jump2;
		}
		System.out.println(sum[N]);
	}
}
