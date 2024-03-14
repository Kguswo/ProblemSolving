import java.util.Scanner;

public class Main {
	static int n, m, max, GCD, MCM;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		max=Integer.MIN_VALUE;
		
		for(int i=1; i<=Math.max(n, m); i++) {
			 if(n%i==0 && m%i==0) max=i;			 
		}
		GCD=max;
		MCM=GCD;
		int idx = 1;
		while(!(MCM%n==0 && MCM%m==0)) {
			MCM=GCD*++idx;
//			System.out.println("idx : " + idx);
		}
		System.out.println(GCD);
		System.out.println(MCM);
	}
}
