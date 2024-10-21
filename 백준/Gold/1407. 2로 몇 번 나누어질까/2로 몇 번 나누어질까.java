/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static long A, B;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());

		long res = calNum(B) - calNum(A-1); 
        bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private long calNum(long num) {
		long tmp = num;
		for(long i=2; i<=num; i<<=1) {
			tmp += (num/i) * (i>>1);
		}
		return tmp;
	}
}