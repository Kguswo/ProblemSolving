// 버퍼로 수정
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int start = 1, empty = 2, end = 3;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		bw.write(Integer.toString(hanoicount(K)) + "\n");
		hanoi(bw, start, empty, end, K);

//		Scanner sc = new Scanner (System.in);
//		int K = sc.nextInt();
//		System.out.println(hanoicount(K));
//		hanoi(start, empty, end, K);
//		sc.close();
		br.close();
		bw.close();
	}

	// n개를 1에서 3으로 옮기기
	public static void hanoi(BufferedWriter bw, int start, int empty, int end, int n) throws IOException { // 하노이탑 이동 경로
		// 1개면 1 -> 3 끝
		if (n == 1) {
            bw.write(start + " " + end + "\n");
		} else { // 1~n개 옮길때
			hanoi(bw, start, end, empty, n - 1); // 시작탑의 n-1개 빈칸탑으로 이동
			bw.write(start + " " + end + "\n"); // 1->3 제일 큰 원판을 시작탑에서 목표탑으로 옮기기 고정
			hanoi(bw, empty, start, end, n - 1); // 빈칸탑으로 옮긴 n-1개 목표탑으로 이동
		}
	}

	public static int hanoicount(int n) {
		if (n == 1) {
			return 1;
		} else {
			count = 2 * hanoicount(n - 1) + 1;
		}
		return count;
	}
}

