import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt(); // 테스트케이스 수
		for (int tc = 0; tc < TC; tc++) {
			Queue<Integer> queue = new LinkedList<>();
			queue.clear();
			N = sc.nextInt(); // 문서의 개수
			M = sc.nextInt(); // 궁금한 문서 위치
			count = 0; // 출력할 프린
			int max = Integer.MIN_VALUE;

			for (int j = 0; j < N; j++) {
				int num = sc.nextInt();
				queue.add(num);
				if (max < num) max = num;
			}
			while (true) {
				if (M == 0 && queue.peek() == max) {
					queue.poll();
					break;
				}
				if (queue.peek() == max) {
					queue.poll();
					count++; M--;
				} else if (queue.peek() != max) {
					int k = queue.poll();
					queue.add(k);
					
					if (M == 0) M = queue.size() - 1;
					else M--;
				}

				max = Integer.MIN_VALUE;
				for (int leftnum : queue) {
					if (max < leftnum)
						max = leftnum;
				}
			}
			count++;
			System.out.println(count);
		}
	}
}
