import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int startidx = 1000;
	static int endidx = 0;
	static int maxidx;
	static int maxheight=0;
	static int arr[];
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int [1001];

		for(int n=0; n<N; n++) {
			int idx = sc.nextInt();
			int height = sc.nextInt();
			startidx = Math.min(idx, startidx);
			endidx = Math.max(idx, endidx);
			maxheight = Math.max(maxheight, height);
			arr[idx] = height;
		}
//		System.out.println(Arrays.toString(arr));
		for(int i=startidx ; i<=endidx ; i++) {
			if(arr[i] == maxheight) maxidx = i;
		}

		// 맨 왼쪽 최댓값 높이
		if(arr[startidx] == maxheight) {
			int tmpmax = arr[endidx];
			sum = tmpmax;
			for(int i=endidx; i>startidx; i--) {
				tmpmax = Math.max(tmpmax, arr[i-1]);
				sum += tmpmax;
			}
		}
		// 맨 오른쪽 최댓값 높이
		else if(arr[endidx] == maxheight) {
			int tmpmax = arr[startidx];
			sum = tmpmax;
			for(int i=startidx; i<endidx; i++) {
				tmpmax = Math.max(tmpmax, arr[i+1]);
				sum += tmpmax;
			}
		}
		// 그 외 중간 최댓값 높이
		else {
			int tmpmaxleft = arr[startidx];
			int tmpmaxright = arr[endidx];
			sum = -arr[maxidx] + arr[startidx] + arr[endidx];
			for(int i=startidx; i<maxidx; i++) {
				tmpmaxleft = Math.max(tmpmaxleft, arr[i+1]);
				sum += tmpmaxleft;
			}
			for(int i=endidx; i>maxidx; i--) {
				tmpmaxright = Math.max(tmpmaxright, arr[i-1]);
				sum += tmpmaxright;
			}
		}
		System.out.println(sum);
	}
}
