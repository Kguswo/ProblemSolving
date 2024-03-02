import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args)  {
      Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<>();
			int length = sc.nextInt();
			String str = sc.next();
			for(int i=0; i<length; i++) {
				if(str.charAt(i)== '(' || str.charAt(i)=='{' || str.charAt(i)=='['|| str.charAt(i)=='<') {
					stack.add(str.charAt(i));
				}
				else if(str.charAt(i)== ')') {
					if(stack.peek() == '(') stack.pop();
					else stack.add(str.charAt(i));
				}
				else if(str.charAt(i)== '}') {
					if(stack.peek() == '{') stack.pop();
					else stack.add(str.charAt(i));
				}
				else if(str.charAt(i)== ']') {
					if(stack.peek() == '[') stack.pop();
					else stack.add(str.charAt(i));
				}
				else if(str.charAt(i)== '>') {
					if(stack.peek() == '<') stack.pop();
					else stack.add(str.charAt(i));
				}
			}
			if(stack.isEmpty()) System.out.printf("#%d %d\n", tc, 1);
			else System.out.printf("#%d %d\n", tc, 0);
		}
	}
}