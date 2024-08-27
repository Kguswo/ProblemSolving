import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static int len, maxLen, pi[];
	static String str;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		str = br.readLine();
		len = str.length();

		int i;
		for(i=0; i<len; i++) {
			String subString = str.substring(i); // 접미사
//			System.out.println(subString);
			maxLen = Math.max(maxLen, KMP(subString));
		}
		System.out.println(maxLen);
		
	}
	
	/**
	 * pi라는 실패함수 만들기
	 * 
	 * @param subString 비교할 패턴
	 * @return maxLen 최대 패턴 길이
	 */
	private static int KMP(String subString) {

		pi = new int[subString.length()];
		int pt_idx=0; int max=0;

		int str_idx;
		for(str_idx = 1; str_idx<subString.length(); str_idx++) {
			
			while(pt_idx>0 && subString.charAt(str_idx) != subString.charAt(pt_idx)) {
				pt_idx = pi[pt_idx-1];
			}
			
			if(subString.charAt(str_idx) == subString.charAt(pt_idx)) {
				pi[str_idx] = ++pt_idx;
				max = Math.max(max, pi[str_idx]);
			}
			
		}
		
//		System.out.println(Arrays.toString(pi));

		return max;
	}

}
