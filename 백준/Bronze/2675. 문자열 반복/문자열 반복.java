import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int T, R;
	static String S;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		T = sc.nextInt();
		for(int i=0; i<T; i++) {
			R = sc.nextInt();
			S = sc.next();
			String str = "";
			
			for(int j=0; j<S.length(); j++) {
				for(int k=0; k<R; k++) {
					str += S.charAt(j);
				}
			}
			System.out.println(str);
		}
		
	}
}
