import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		while(queue.size()>=2) {
			System.out.print(queue.peek() + " ");
			queue.poll();
			if(queue.size()==1) break;
			int tmp = queue.poll();
			queue.add(tmp);
		}
		System.out.println(queue.peek());
	}
}