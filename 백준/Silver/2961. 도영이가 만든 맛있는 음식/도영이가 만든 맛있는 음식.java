/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, visited, flavor[][], res=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		visited = 0;
		flavor = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new  StringTokenizer(br.readLine());
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0, visited, 1, 0);
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private void dfs(int depth, int visited, int sour, int bitter) {
		if(depth == N) {
			if(visited > 0) {
				res = Math.min(res, Math.abs(sour - bitter));
			}
			return;	
		}
		
		dfs(depth + 1, visited | (1<<depth), sour * flavor[depth][0], bitter + flavor[depth][1]);
		dfs(depth + 1, visited, sour, bitter);
		
	}
}