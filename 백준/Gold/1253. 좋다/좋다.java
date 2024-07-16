import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, ans;
	static long arr[], num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		N = Integer.parseInt(br.readLine());
		ans = 0;
		arr = new long [N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		/*
		 * 배열 돌면서 각 원소를 더해서 만들 수 있는지 체크할 것.
		 * 찾고자 하는 값보다 합이 작으면 왼쪽 포인터를 오른쪽으로 (a) 
		 * 찾고자 하는 값보다 크면 오른쪽 포인트를 왼쪽으로 (b)
		 * 반복하면서 합을 num과 비교하고 L,R 가깝게 만들면서 중앙으로 다가가기
		 */
			for(int i=0; i<N; i++) {
			num = arr[i];
			int L = 0; 
			int R = N-1;
			
			while(L<R) {
				if(arr[L] + arr[R] == num) {
					if(L == i) L++;
					else if(R == i) R--;
					else if(L != i && R !=i) {
						ans++;
						break;
					}
				}
				else if(arr[L]+arr[R] < num) L++; // (a)
				else R--; // (b)
			}
		}
		System.out.println(ans);
	}
}
