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
			count = 0;
			int max = Integer.MIN_VALUE;

			for (int j = 0; j < N; j++) {
				int num = sc.nextInt();
				queue.add(num);
				if (max < num) max = num;
			}
			while (true) {
				if (M == 0 && queue.peek() == max) { // 찾고자 하는 원소가 front에 있으면서 최대값이면 제거하고 종료
					queue.poll();
					break;
				}
				if (queue.peek() == max) { // 찾고자하는 원소는 아니지만 최대값이면 제거하고 개수추가, 찾는원소 인덱스 -1
					queue.poll();
					count++; M--;
				} else if (queue.peek() != max) { //  그 외 경우 front원소 제거 후 맨 뒤로 add, 찾는원소 인덱스 수정 
					int k = queue.poll();
					queue.add(k);
					
					if (M == 0) M = queue.size() - 1;
					else M--;
				}

				max = Integer.MIN_VALUE; // 다음 반복문 돌기 전에 최댓값 재갱신
				for (int leftnum : queue) {
					if (max < leftnum)
						max = leftnum;
				}
			}
			count++; // 찾는원소가 front에 있으면서 최댓값일때 종료했으므로 마지막으로 count +1
			System.out.println(count);
		}
	}
}