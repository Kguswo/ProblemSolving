import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ans = "";
		for(char x : str.toCharArray()) {
        
			if(Character.isLowerCase(x)) {
				ans += Character.toUpperCase(x);
			} else {
				ans += Character.toLowerCase(x);
			}
            
		}
		System.out.println(ans);
	}
}