import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i=0; i<26; i++	) {
			boolean found = false;
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) - 'a' == i) {
					found = true;
					System.out.print(j + " ");
					break;
				}
			}
			if(!found) System.out.print(-1 + " ");
		}
	}
}