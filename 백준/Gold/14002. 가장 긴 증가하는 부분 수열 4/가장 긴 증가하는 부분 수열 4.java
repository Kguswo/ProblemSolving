/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp, 1);
		
		st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
		List<Integer> res = new ArrayList<Integer>();
		int maxLen = 1;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			maxLen = Math.max(maxLen, dp[i]);
		}

		// 역추적
		int len = maxLen;
        for(int i=N; i>=1; i--) {
            if(dp[i] == len) {
                res.add(arr[i]);
                len--;
            }
        }
		sb.append(maxLen).append("\n");
		for(int i=res.size()-1; i>=0; i--) {
            sb.append(res.get(i) + " ");
        }
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}