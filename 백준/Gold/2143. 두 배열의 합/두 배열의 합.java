import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int a[], b[];
	static HashMap<Long, Integer> map;
	public static void main(String[] args) throws IOException {
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		a = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			a[i] = a[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		b = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			b[i] = b[i-1] + Integer.parseInt(st.nextToken());
		}
		
		map = new HashMap<Long, Integer>();
		long ans = 0;
		
		for(int i=0; i<=M; i++) {
			for(int j=i+1; j<=M; j++) {
				long sum = b[j] - b[i];
				map.put(sum, map.getOrDefault(sum, 0)+1);
			}
		}
		
		for(int i=0; i<=N; i++) {
			for(int j=i+1; j<=N; j++) {
				long sum = a[j] - a[i];
				ans += map.getOrDefault(T-sum, 0);
			}
		}
		
		System.out.println(ans);
		
	}
}
