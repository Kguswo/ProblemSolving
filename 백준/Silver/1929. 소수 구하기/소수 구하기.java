import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int M, N;
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		findPrimenum(M, N);
		for(int num : list) {
			System.out.println(num);
		}
	}
	private static void findPrimenum(int m, int n) {
		for(int i=m; i<=n; i++) {
			boolean flag = true;
			if(i == 1) flag = false;
			else if (i ==2  || i==3) flag = true;
			else {
				for(int j=2; j<=(int) Math.sqrt(i)+1; j++) {
					if(i%j==0) {
						flag=false;
						break;
					}
				}							
			}
			if(flag) list.add(i);
		}
	}
}
