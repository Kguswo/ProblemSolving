
/**
 * Author : nowalex322, Kim Hyeonjae
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N;
	static long x[], y[];

	public static void main(String[] args) throws IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		x = new long[N + 1];
		y = new long[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());

		}
		x[N] = x[0];
		y[N] = y[0];
		
		double ans = 0;
		for(int i=0; i<N; i++){
			ans += x[i]*y[i+1] - x[i+1]*y[i];
		}
		ans = Math.abs(ans)/2.0;
		System.out.println(String.format("%.1f", ans));
	}
}