import java.io.*;
import java.util.*;

public class Main {

	/**
	 * height : 키
	 * num : 같은키 가진 연속된 사람 수
	 */
	static class Person {
		int height;
		int pairNum;

		public Person(int height, int pairNum) {
			this.height = height;
			this.pairNum = pairNum;
		}
		
	    @Override
	    public String toString() {
	        return "(" + height + "," + pairNum + ")";
	    }
	}

	static BufferedReader br;
	static int N, arr[];
	static long ans;
	static Stack<Person> stack;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stack = new Stack<>();

		int i;
		for (i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		/**
		 * 지금 사람보다 키가 작은 사람들은 모두 볼 수 있으므로 볼 수 있는 쌍의 수 추가하고 스택에서 제거.
		 * 자신보다 큰 사람은 1명만 볼 수 있음
		 * 최종적으로 스택에는 키가 중간중간 작은애들 빠지고 내림차순으로 남을것이다.
		 * 시간복잡도 O(N)
		 */
		
		long cnt = 1;
		int j;
		for (j = 0; j < N; j++) {
			int tmp = arr[j];
			int tmpNum = 1;

//	        System.out.println("\n처리 중인 사람: 키 " + tmp);
//	        System.out.println("처리 전 스택: " + stack);
	        
			// 현재 사람보다 키가 작은 사람들을 스택에서 제거하며 쌍의 수 추가
			while (!stack.isEmpty() && tmp > stack.peek().height) {
				ans += stack.peek().pairNum;
				stack.pop();
//	            System.out.println("팝: " + stack.pop() + ", ans = " + ans);

			}
			
			// 남은 자신보다 크거나 같은 사람들
			if (!stack.isEmpty()) {
				if (stack.peek().height == arr[j]) { // 같은 키
					ans += stack.peek().pairNum;
					tmpNum = stack.peek().pairNum + 1;
					if (stack.size() > 1)
						ans++;
					stack.pop();
//	                System.out.println("같은 키 처리: " + stack.pop() + ", ans = " + ans + ", tmpCnt = " + tmpNum);

				} else {  // 자신보다 큰 사람
					ans++;
//	                System.out.println("큰 사람 처리: ans = " + ans);

				}
			}
			stack.push(new Person(arr[j], tmpNum));
//	        System.out.println("푸시 후 스택: " + stack);

		}
		System.out.println(ans);
	}
}