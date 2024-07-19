import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
	static int N, M, cnt;
    static String[] arr;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		arr = new String[N];

		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
			if(arr[i].contains("X") == false) cnt++;
		}
		
		int max = cnt;
		cnt = 0;
		
		for(int i = 0; i < M; i++) {
			int counts = 0;
			for(int j = 0; j < N; j++) {
				if(arr[j].charAt(i) == '.') {
					counts++;
				}
			}
			if(counts == N) cnt++;
		}
		max = Math.max(max, cnt);
		System.out.println(max);
	}
}