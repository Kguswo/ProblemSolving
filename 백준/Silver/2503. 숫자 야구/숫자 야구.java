/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=123; i<=987; i++) {
			String str = String.valueOf(i);
			if(str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(2) == str.charAt(0)) continue;
			if(str.charAt(0) == '0' || str.charAt(1)== '0' || str.charAt(2) == '0') continue;
			list.add(i);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
		    List<Integer> newList = new ArrayList<>();

			for(int num : list) {
				int s = 0, b = 0;
				for(int j=0; j<3; j++) {
					char c1 = String.valueOf(input).charAt(j);
					for(int k=0; k<3; k++) {
						char c2 = String.valueOf(num).charAt(k);
						if(c1 == c2 && j == k) s++;
						else if(c1 == c2 && j != k) b++;
					}
				}
				
				if(s == strike && b == ball) newList.add(num);
			}
			list = newList;
		}
		res = list.size();
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}
}
