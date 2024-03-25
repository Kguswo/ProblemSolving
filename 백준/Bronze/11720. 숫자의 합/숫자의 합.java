import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int T, sum;
	static String S;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		T = sc.nextInt();
		S = sc.next();
		sum = 0;
		for(int i=0; i<T; i++) {
			sum += S.charAt(i)-'0';
		}
		System.out.println(sum);
	}
}
