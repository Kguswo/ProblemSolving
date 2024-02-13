import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> arr = new ArrayList<>();
		while (true) {
			String str = sc.nextLine();
			if (str.equals("."))
				break;
			arr.add(str);
		}
		for (int i = 0; i < arr.size(); i++) {
			Stack<Character> stack = new Stack<>();
			String str2 = arr.get(i);
			boolean able = true;
			for (int j = 0; j < str2.length(); j++) {
				if (str2.charAt(j) == '[' || str2.charAt(j) == '(') stack.push(str2.charAt(j));
					
				else if (str2.charAt(j) == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						able = false;
						break;
					} 
					else	stack.pop();
				} 
				
				else if (str2.charAt(j) == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						able = false;
						break;
					} 
					else	stack.pop();
				}
			}
			if ( !stack.isEmpty() || !able) System.out.println("no");
			else System.out.println("yes");
		}
	}
}
