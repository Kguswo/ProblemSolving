/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
	static int N;
	static int[] arr;
	static int[][] dp;
	static List<Integer>[] graph;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1623_신년파티/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

		arr = new int[N+1];
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		dp = new int[N+1][2];
		visited = new boolean[N+1][2];

		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int child=2; child<=N; child++) {
			int parent = Integer.parseInt(st.nextToken());
			graph[parent].add(child);
		}

		dfs(1);

		sb.append(dp[1][1]).append(" ").append(dp[1][0]).append("\n");

		List<Integer> withBoss = new ArrayList<>();
		List<Integer> withoutBoss = new ArrayList<>();

		findPath(1, true, withBoss);
		findPath(1, false, withoutBoss);
		Collections.sort(withBoss);
		Collections.sort(withoutBoss);

		for(int w : withBoss) {
			sb.append(w).append(" ");
		}
		sb.append(-1).append("\n");
		for(int w : withoutBoss) {
			sb.append(w).append(" ");
		}
		sb.append(-1);

		System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

	private void findPath(int i, boolean visited, List<Integer> res) {
		if(visited) {
			res.add(i);

			for(int g : graph[i]) {
				findPath(g, false, res);
			}
		}
		else{
			for(int g : graph[i]) {
				if(dp[g][1] > dp[g][0]){ // 부하 선택하는게 더 클 때
					findPath(g, true, res);
				}
				else{ // 부하 선택x 가 더 클 때
					findPath(g, false, res);
				}
			}
		}
	}

	private void dfs(int i) {
		dp[i][0] = 0;
		dp[i][1] = arr[i];

		for(int g : graph[i]) {
			dfs(g);
			dp[i][0] += Math.max(dp[g][0], dp[g][1]); // 본인안오면 부하는 오거나 안오거나
			dp[i][1] += dp[g][0]; // 본인 오면 부하는 못옴
		}
	}
}