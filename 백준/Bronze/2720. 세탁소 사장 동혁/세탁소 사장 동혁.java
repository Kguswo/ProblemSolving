/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] divide = {25, 10, 5, 1};
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tt = Integer.parseInt(br.readLine());
		while(tt-->0) {
			int price = Integer.parseInt(br.readLine());
			sb.append(price / divide[0]).append(" ");
			price %= divide[0];
			sb.append(price / divide[1]).append(" ");
			price %= divide[1];
			sb.append(price / divide[2]).append(" ");
			price %= divide[2];
			sb.append(price / divide[3]).append(" ").append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}