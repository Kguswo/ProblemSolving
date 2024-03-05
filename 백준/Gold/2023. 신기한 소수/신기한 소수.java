import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
	}
	static void dfs(int num	, int digit) {
		if(digit == N) {
			if(primenum(num) == true) {
				System.out.println(num);
			}
			return;
		}
		for(int i=1; i<10; i+=2) {
			if(i%2==0) continue; // 짝수 넘어가기
			if(primenum(num*10+i) == true) {
				dfs(num*10+i, digit+1);				
			}
		}
	}
	
	static boolean primenum(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num%i ==0) return false;
		}
		return true;
	}
}
