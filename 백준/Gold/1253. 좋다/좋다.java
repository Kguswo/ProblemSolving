import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
		int ans = 0;
		long arr[] = new long [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
//			arr[i] = sc.nextLong();
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		
		for(int k=0; k<N; k++) {
			long target = arr[k];
			int pointer1 = 0; 
			int pointer2 = N-1;
			
			// 투 포인터 구현
			while(pointer1<pointer2) {
				if(arr[pointer1] + arr[pointer2] == target) {
					if(pointer1 != k && pointer2 !=k) {
					ans++;
					break;
					}
					else if(pointer1 == k) pointer1++;
					else if(pointer2 == k) pointer2--;
				}
				else if(arr[pointer1] + arr[pointer2] < target) {
					pointer1++;
				}
				else {
					pointer2--;
				}
			}
		}
		System.out.println(ans);
	}
}
