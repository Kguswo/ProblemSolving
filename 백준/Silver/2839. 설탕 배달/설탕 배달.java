import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		if(N==4 || N==7) {
			System.out.println(-1);
			return;
		}
		if(N%10==0||N%10==5) System.out.println(N/5);
		else if (N%10==1||N%10==6) System.out.println(2+(N-6)/5);
		else if (N%10==2||N%10==7) System.out.println(4+(N-12)/5);
		else if (N%10==3||N%10==8) System.out.println(1+(N-3)/5);
		else if (N%10==4||N%10==9) System.out.println(3+(N-9)/5);
	}
}
