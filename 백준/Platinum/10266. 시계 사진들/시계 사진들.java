import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int n;
	static boolean[] clock1, clock2;
	static int[] pi;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		n = Integer.parseInt(br.readLine());
		clock1 = new boolean[720000];
		clock2 = new boolean[360000];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int n = Integer.parseInt(st.nextToken());
			clock1[n] = true;
			clock1[n + 360000] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int n = Integer.parseInt(st.nextToken());
			clock2[n] = true;
		}
		pi = getPi();
		
		System.out.println(KMP() ? "possible" : "impossible");
	}
    
	private static boolean KMP() {
		int j=0;
		for(int i=0; i<720000; i++) {
			 while(j>0 && clock1[i] != clock2[j]) {
				 j = pi[j-1];
			 }
			 if(clock1[i] == clock2[j]) {
				 if(j==359999) {
//					 j=pi[j];
					 return true;
				 }
				 else j++;
			 }
		 }
		return false;		
	}
    
	private static int[] getPi() {
		 int[] pi = new int[360000];
		 int j=0;
		 for(int i=1; i<360000; i++) {
			 while(j>0 && clock2[i] != clock2[j]) {
				 j = pi[j-1];
			 }
			 if(clock2[i] == clock2[j]) pi[i] = ++j;
		 }
		 return pi;
	}
}
