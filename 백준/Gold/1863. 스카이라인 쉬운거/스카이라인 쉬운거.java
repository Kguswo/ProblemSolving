import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int n, x, y, top, cnt;
	static Stack<Integer> stack;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		stack = new Stack<>();
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			if(y>0) {
                
				if (stack.isEmpty()) stack.push(y);
				
				if(!stack.isEmpty()) {
					if (stack.peek() > y) {
						while(!stack.isEmpty() && stack.peek()>y) {
							stack.pop();
							cnt++;
						}
					}
					if(stack.isEmpty()) stack.push(y);
					else if(stack.peek() < y) stack.push(y);
					else continue;
				}
			}
			else {
				cnt += stack.size();
				stack.clear();
			}
		}
		cnt += stack.size();
		System.out.println(cnt);
	}
}
