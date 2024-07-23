import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, height[], sum[], a, b, k;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
	
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());	
		height = new int[N+1];
		sum = new int[N+2];
		for(int i=1; i<=N; i++) {	
			height[i] = Integer.valueOf(st.nextToken());
		}

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());	
			a = Integer.valueOf(st.nextToken());
			b = Integer.valueOf(st.nextToken());
			k = Integer.valueOf(st.nextToken());
			sum[a] += k;
			sum[b+1] -= k;
		}
		
		for(int i=1; i<=N; i++) {	
			sum[i] += sum[i-1];
		}
		
		for(int i=1; i<=N; i++) {	
			height[i] += sum[i];
			sb.append(height[i] + " ");
		}

		System.out.println(sb.toString());
	}
}
