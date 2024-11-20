/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, line[][], dp[][];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	/*
	 * 교차되지 않는 정답군 크기를 dp로 저장할거고 그 dp배열 채울 값을 구간으로 정의하여 구분.
	 * i~j구간의 정답크기는 dp[i][j]로. 이때 이를 작은 부분으로 쪼개면 i<=mid<j일 때
	 * dp[i][j]를 갱신하려면 dp[i][mid] + dp[mid][j]로 쪼갤 수 있다.
	 * 또한 구간 전체를 길이로 하는 선분도 고려해야하므로 이를 검색해 더해줌.
	 */
	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		line = new int[101][101];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			line[A][B]++;
			line[B][A]++;
		}
		
		dp = new int[101][101];
		for(int i=1; i<=100; i++) {
			for(int j=i; j>=1; j--) {
				for(int mid = j; mid<i; mid++) {
					dp[j][i] = Math.max(dp[j][i], dp[j][mid] + dp[mid][i] + line[j][i]);
				}
			}
		}
		bw.write(String.valueOf(dp[1][100]));

		bw.flush();
		bw.close();
		br.close();
	}
}