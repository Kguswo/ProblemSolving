import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution{
	
		static int[] stack; 
		static int top = -1;
		public static void main(String[] args) throws FileNotFoundException {
	
//		File file = new File("src/input.txt");
//		Scanner sc = new Scanner(file);
		Scanner sc  = new Scanner(System.in);

		int TC = sc.nextInt();

		for(int t = 1; t<=TC; t++) {
			int N = sc.nextInt();
			stack = new int[N];
			for(int i=0; i<N; i++) {
				int num = sc.nextInt();
				if( num == 0) {
					pop();
				}else {
					push(num);
				}
//			System.out.println(Arrays.toString(stack));
			}
			long sum = 0;
			for(int i=0; i<=top; i++) {
				sum += stack[i];
			}
		System.out.printf("#%d %d\n", t, sum);
			top = -1;
		}
	
		sc.close();
	}
	static boolean isEmpty() {
		return top == -1;
	}
	static boolean isFull() {
		return top == stack.length-1;
	}
	static void push(int num) {
		if(isFull()) {
			System.out.println("꽉 찼으므로 넣을 수 없음.");
			return;
		}
		stack[++top] = num;

	}

	static int pop() {
		if (isEmpty()) {
			System.out.println("비었기 때문에 pop불가능.");
			return Integer.MIN_VALUE;
		}
		return stack[top--] = 0;
	}
}