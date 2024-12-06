/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int[] dr = {0, -1, 0, 1}, dc = {-1, 0, 1, 0};
	static int N, board[][], max=-210, min=210;
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N+2][N+2];
		for(int i=0; i<N+2; i++) {
			Arrays.fill(board[i], -1);
		}
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] > max) max=board[i][j];
				if(board[i][j]<min) min = board[i][j];
			}
		}
		
		int res = 210;
		int left = 0;
		int right = max-min;
		while(left<=right) {
			int mid = left + (right-left)/2;
			boolean flag = false;
			
			for(int i=min; i<=max-mid; i++) {
				int j = i + mid;
				if(board[1][1]>=i && board[1][1] <= j) {
					if(canGo(i, j)) {
						flag = true;
						break;
					}
				}
			}
			
			if(flag) {
				res = mid;
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private boolean canGo(int min, int max) {
		Queue<int[]> queue = new LinkedList<int[]>();
		visited = new boolean[N+2][N+2];
		
		queue.offer(new int[]{1, 1});
		visited[1][1] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currNum = board[curr[0]][curr[1]];
			
			if(curr[0] == N && curr[1] == N) return true;
			
			for(int k=0; k<4; k++) {
				int[] next = {curr[0] + dr[k], curr[1] + dc[k]};
				
				if(board[next[0]][next[1]] == -1 || visited[next[0]][next[1]]) continue;
				if(board[next[0]][next[1]] >= min && board[next[0]][next[1]] <= max) {
					queue.offer(next);
					visited[next[0]][next[1]] = true;
				}
			}
		}
		return false;
	}
}