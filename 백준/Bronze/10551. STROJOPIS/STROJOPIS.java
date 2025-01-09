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
		String str = br.readLine();
		int[] arr = new int[8];
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='1' || str.charAt(i)=='Q'||str.charAt(i)=='A'||str.charAt(i)=='Z') arr[0]++;
			else if(str.charAt(i)=='2'||str.charAt(i)=='W'||str.charAt(i)=='S'||str.charAt(i)=='X') arr[1]++;
			else if(str.charAt(i)=='3'||str.charAt(i)=='E'||str.charAt(i)=='D'||str.charAt(i)=='C') arr[2]++;
			else if(str.charAt(i)=='4'||str.charAt(i)=='R'||str.charAt(i)=='F'||str.charAt(i)=='V'||str.charAt(i)=='5'||str.charAt(i)=='T'||str.charAt(i)=='G'||str.charAt(i)=='B') arr[3]++;
			else if(str.charAt(i)=='6'||str.charAt(i)=='Y'||str.charAt(i)=='H'||str.charAt(i)=='N'||str.charAt(i)=='7'||str.charAt(i)=='U'||str.charAt(i)=='J'||str.charAt(i)=='M') arr[4]++;
			else if(str.charAt(i)=='8'||str.charAt(i)=='I'||str.charAt(i)=='K'||str.charAt(i)==',') arr[5]++;
			else if(str.charAt(i)=='9'||str.charAt(i)=='O'||str.charAt(i)=='L'||str.charAt(i)=='.') arr[6]++;
			else arr[7]++;
		}
		for(int i : arr) {
			System.out.println(i);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}