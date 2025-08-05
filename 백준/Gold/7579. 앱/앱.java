/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
	static int N, M;
	static int[] memory, cost;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_7579_앱/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		memory = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		cost = new int[N];
		int maxCost = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			maxCost += cost[i];
		}

		int[] dp = new int[maxCost + 1]; // dp[i]= i비용으로 확보가능한 최대 메모리
		for(int i=0; i<N; i++) {
			for(int j=maxCost; j>=cost[i]; j--){
				dp[j] = Math.max(dp[j], dp[j-cost[i]] + memory[i]);
			}
		}

		for(int i=0; i<=maxCost; i++) {
			if(dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}


        bw.flush();
        bw.close();
        br.close();
    }
}