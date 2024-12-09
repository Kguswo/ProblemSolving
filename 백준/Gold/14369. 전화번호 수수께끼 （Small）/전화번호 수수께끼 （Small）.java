
/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	class Number {
		String s;
		char c;
		int n;

		public Number(String s, char c, int n) {
			this.s = s;
			this.c = c;
			this.n = n;
		}
	}

	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	Number[] number = { new Number("ZERO", 	'Z', 0),
						new Number("SIX", 	'X', 6), 
						new Number("EIGHT", 'G', 8), 
						new Number("TWO", 	'W', 2),
						new Number("THREE", 'T', 3), 
						new Number("SEVEN", 'S', 7), 
						new Number("FIVE", 	'V', 5), 
						new Number("FOUR", 	'F', 4),
						new Number("NINE", 	'I', 9), 
						new Number("ONE", 	'N', 1) };

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <=T; tc++) {
			/*
			 * 1. 0 : Z 개수로 찾기 - 25
			 * 2, 6 : X 개수로 찾기 - 23
			 * 3. 8 : G 개수로 찾기 - 6
			 * 4. 2 : W개수로 찾기 - 22
			 * 5. 3 : TWO, EIGHT 찾은 후 T로 찾기 - 19
			 * 6. 7 : SIX 찾은 후 S로 찾기 - 18
			 * 7. 5 : SEVEN 다 찾은 후 V로 찾기 - 21
			 * 8. 4 : FIVE 다 찾은 후 F로 찾기 - 5
			 * 9. 9 : I 개수로 찾기 - 8
			 * 10 0 : 나머지 N개수로 찾기 - 13
			 */

			int[] arr = new int[26]; // A~Z;
			String str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'A']++;
			}

			int[] numCnt = new int[10];
			for (int i = 0; i < 10; i++) {
				int tmpCnt = 0;
				if (arr[number[i].c-'A'] > 0) {
					tmpCnt = arr[number[i].c-'A'];
					numCnt[number[i].n] += tmpCnt;
					for (int j = 0; j < number[i].s.length(); j++) {
						arr[number[i].s.charAt(j)-'A'] -= tmpCnt;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<10; i++) {
				for(int j=0; j<numCnt[i]; j++) {
					sb.append(i);					
				}
			}
			bw.write("Case #" + tc + ": " + sb.toString() + "\n");
		}


		bw.flush();
		bw.close();
		br.close();
	}
}
