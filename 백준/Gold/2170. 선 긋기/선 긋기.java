
/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, line[][];

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		line = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			line[i][0] = x;
			line[i][1] = y;
		}

		Arrays.sort(line, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]); // 오름차순

		long res = 0;
		int left = line[0][0];
		int right = line[0][1];

		for (int[] l : line) {
			// 새 선 시작이 원래 선 내부일때 (겹침포함)
			if (l[0] <= right) {
				right = Math.max(right, l[1]);
			}
			// 외부일떄
			else {
				res += right - left;
				left = l[0];
				right = l[1];
			}
		}

		res += right - left;
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}
}