import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] strarr = str.split(" ");
		int count = 0;
		for(String i : strarr) {
			if(!(i.equals(""))) count++; 
		}
		System.out.println(count);
	}
}
