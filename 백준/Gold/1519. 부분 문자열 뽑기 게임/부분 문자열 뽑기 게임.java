
/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, dp[];

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		if (N < 10)
			bw.write("-1");
		else {
			dp = new int [N+1];
			int res = getMinNum(N);
			bw.write(String.valueOf(res));
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private int getMinNum(int num) {
		if(dp[num] != 0) return dp[num];
		
		if(num <= 9) {
			dp[num] = -1;
			return dp[num];
		}

		String s = String.valueOf(num);
		Set<Integer> subset = new HashSet<>();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '0') continue;
			StringBuilder sb = new StringBuilder();
			
			for(int j=i; j<s.length(); j++) {
				sb.append(s.charAt(j));
				if(!sb.toString().equals(s)) subset.add(Integer.parseInt(sb.toString()));
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int curr : subset) {
			if(curr < num) {
				int nextNum = num - curr;
				int nextVal = getMinNum(nextNum);
				
				if(nextVal == -1) min = Math.min(min, curr);
			}
		}
		
		dp[num] = (min == Integer.MAX_VALUE) ? -1 : min;
		return dp[num];
	}
}