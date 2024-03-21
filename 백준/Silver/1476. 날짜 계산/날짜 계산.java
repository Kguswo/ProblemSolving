import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = 1;
		int S = 1;
		int M = 1;
		int count = 1;
		int e = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		
		while(true) {
			int newE = (E-1)%15+1;
			int newS = (S-1)%28+1;
			int newM = (M-1)%19+1;
			if(newE == e && newS == s && newM == m) {
				break;
			}
			E++;
			S++;
			M++;
			count++;
		}
		System.out.println(count);
	}
}
