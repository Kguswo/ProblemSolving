import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int T;
	static int count=0;
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++) {
			list.add(sc.nextInt());
		}
		
		findPrimenum(list);
		System.out.println(count);
	}
	private static void findPrimenum(List<Integer> list) {
		for(int num : list) {
			boolean flag = true;
			if(num == 1) flag = false;
			else if (num ==2  || num==3) flag = true;
			else {
				for(int i=2; i<=(int) Math.sqrt(num)+1; i++) {
					if(num%i==0) {
						flag=false;
						break;
					}
				}							
			}
			if(flag) count++;
		}
	}
}
