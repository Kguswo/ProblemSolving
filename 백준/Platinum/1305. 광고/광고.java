import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String T;
	static int L, pi[];
	static List<Integer> positions;

	public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		
		L = Integer.parseInt(br.readLine());
		T = br.readLine();
		System.out.println(getMinLength());
		
	}

	private static int getMinLength() {
		int[] pi = new int[T.length()];
		int j=0; 
		int min = 987654321;
		
		for(int i=1; i<T.length(); i++) {
			while(j>0 && T.charAt(i) != T.charAt(j)) j = pi[j-1];
			
			if(T.charAt(i) == T.charAt(j)) pi[i] = ++j;
		}
		return T.length() - pi[T.length() - 1];
	}
}
