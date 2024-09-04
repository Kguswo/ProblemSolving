
/**
 * Author : nowalex322, Kim hyeonjae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static int N, num[], cnt;
	static List<Integer> primeNum = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			return;
		}
		if (N == 2) {
			System.out.println(1);
			return;
		}
		makePrimeNum();

		cnt = 0;
		int left = 0, right = 0, sum = primeNum.get(left);

		while (right < primeNum.size() && left < primeNum.size() && left <= right) {
			if(left == primeNum.size()-1 && right == primeNum.size()-1){
				sum = primeNum.get(right);
				break;
			}
//			System.out.println("left : " + primeNum.get(left) + " , right : " + primeNum.get(right) + ", sum : " + sum);
			if (sum >= N && left < right) {
//				System.out.println("왼쪽줄이기");
				sum -= primeNum.get(left++);
			} else {
				if (right < primeNum.size()-1) {
//					System.out.println("오른쪽늘리기");
					sum += primeNum.get(++right);
				}
			}
//			System.out.println("이동 후");
//			System.out.println("left : " + primeNum.get(left) + " , right : " + primeNum.get(right) + ", sum : " + sum);

			if (sum == N) {
//            	System.out.println("left : " + primeNum.get(left) + " , right : " + primeNum.get(right));
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	private static void makePrimeNum() {
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				primeNum.add(i);
			}
		}
	}
}
