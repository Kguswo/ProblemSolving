/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int A, B, N, W;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2015_수들의합4/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B= Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			if (A * i + B * (N - i) == W) {
				sb.append(i).append(" ").append(N - i);
				cnt++;
			}
		}
		if (cnt!=1) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}

        bw.flush();
        bw.close();
        br.close();
    }
}