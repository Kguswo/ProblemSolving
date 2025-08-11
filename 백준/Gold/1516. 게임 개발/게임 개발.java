/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
	static int[] time, indegree, res;
	static int N;
	static ArrayList<Integer>[] board;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1516_게임개발/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			board[i] = new ArrayList<>();
		}

		time = new int[N+1];
		indegree = new int[N+1];
		res = new int[N+1];

		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());

			int n;
			while((n = Integer.parseInt(st.nextToken())) != -1){
				board[n].add(i);
				indegree[i]++;
			}
		}

		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			if(indegree[i]==0){
				dq.offer(i);
				res[i] = time[i];
			}
		}

		while(!dq.isEmpty()){
			int curr = dq.poll();
			for(int next : board[curr]){
				res[next] = Math.max(res[next], res[curr] + time[next]);
				indegree[next]--;
				if(indegree[next]==0){
					dq.offer(next);
				}
			}
		}

		for(int i=1; i<=N; i++) {
			sb.append(res[i]).append("\n");
		}

		System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}