import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int T, N, B;
	static int min;
	static int[] height;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			B = sc.nextInt();
			height = new int[N];
			for(int i=0; i<N; i++) {
				height[i] = sc.nextInt();
			}
			for(int i=1; i<=N; i++) {
				list = new ArrayList<Integer>();
				combination(i, 0, 0);
			}
			System.out.printf("#%d %d\n", tc, min);
		}
	}
	private static void combination(int i, int cnt, int start) {
		if(cnt == i) {
			if(sum(list)>= B) min = Math.min(Math.abs(sum(list) - B), min);
			return;
		}
		for(int j=start; j<N; j++) {
			list.add(height[j]); 
			combination(i, cnt+1, j+1); 
			list.remove(list.size()-1); 
		}
	}
	private static int sum(List<Integer> list) {
		int hsum = 0;
		for(int i:list) hsum += i;
		return hsum;
	}
}