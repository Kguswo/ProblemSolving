import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String T;
	static int L, pi[], maxExp;

	public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        
		while (true) {
            T = br.readLine();
            if (T.equals(".")) break;
            
            maxExp = getMaxExponent();
            bw.write(maxExp + "\n");
        }
		bw.flush();
        bw.close();
        br.close();
	}

	private static int getMaxExponent() {
		int[] pi = new int[T.length()];
		int j=0; 
		int maxExponent = 0;
		
		for(int i=1; i<T.length(); i++) {
			while(j>0 && T.charAt(i) != T.charAt(j)) j = pi[j-1];
			
			if(T.charAt(i) == T.charAt(j)) pi[i] = ++j;
		}
//		System.out.println(Arrays.toString(pi));
		
        int repeatLen = T.length()-pi[T.length()-1];
        return maxExponent = T.length()%repeatLen==0 ? T.length()/repeatLen : 1;

		
	}
}
