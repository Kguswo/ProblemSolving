/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	class Tower{
		int n;
		int h;
		public Tower(int number, int height) {
			this.n = number;
			this.h = height;
		}
	}
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Stack<Tower> stack = new Stack<Tower>();
		
		st = new StringTokenizer(br.readLine());
		int H;
		stack.add(new Tower(0, Integer.MAX_VALUE));
		for(int i=1; i<=N; i++) {
			H = Integer.parseInt(st.nextToken());
			Tower t = new Tower(i, H);
			while(!stack.isEmpty() && stack.peek().h < H) {
				stack.pop();
			}
			sb.append(stack.peek().n).append(" ");
			stack.push(t);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}