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
	static int R, C, board[][], res;
	static int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
	static String[] dir = {"R", "D", "L", "U"};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false; // 모두 순회해도 되면 true, 안되면(짝수 x 짝수) false
		
		flag = !(R%2==0 && C%2==0);
		if(flag) findAll();
		else findExceptMin();

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private void findExceptMin() {
		int min = Integer.MAX_VALUE;
		int minR = -1, minC = -1;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if((i+j)%2 == 1 && board[i][j] < min) {
					min = board[i][j];
					minR = i;
					minC = j;
				}
			}
		}
		
		for(int i=0; i<minR/2; i++) {
	        // 첫 행은 오른쪽으로
	        for(int j=0; j<C-1; j++) {
	            sb.append("R");
	        }
	        sb.append("D");
	        // 두번째 행은 왼쪽으로
	        for(int j=0; j<C-1; j++) {
	            sb.append("L");
	        }
	        sb.append("D");
	    }
		
		int c = 0;
		int r = 2 * (minR/2); // 최솟값 존재 묶음 중 윗줄 
		int nextR = r+1; // 최솟값 존재 묶음 중 아랫줄
		
		while(r != nextR || c != C-1) {
			if(r < nextR && (c != minC || nextR != minR)) {
				r++;
				sb.append("D");
			}
			else if(r == nextR && (c != minC || nextR-1 != minR)) {
				r--;
				sb.append("U");
			}
			
			if(c != C-1) {
	            c++;
	            sb.append("R");
	        }
		}
		
		// 남은 묶음들
	    for(int i=minR/2+1; i<R/2; i++) {
	        sb.append("D");
	        for(int j=0; j<C-1; j++) {
	            sb.append("L");
	        }
	        sb.append("D");
	        for(int j=0; j<C-1; j++) {
	            sb.append("R");
	        }
	    }
		
//		visited[minR][minC] = true;
//		dfs(0, 0, 1);
	}

//	private boolean dfs(int r, int c, int cnt) { // 시간초과
//		if(r == R-1 && c == C-1) return cnt == R * C - 1;
//		
//		visited[r][c] = true;
//		
//		for(int k=0; k<4; k++) {
//			int nr = r + dr[k];
//			int nc = c + dc[k];
//			
//			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
//				sb.append(dir[k]);
//				if(dfs(nr, nc, cnt + 1)) return true;
//				sb.setLength(sb.length()-1);
//			}
//		}
//		
//		visited[r][c] = false;
//		return false;
//	}

	private void findAll() {
		if(R % 2 == 1) {
			for(int i=1; i<=R; i++) {
				if(i%2 == 1) {
					for(int j=0; j<C-1; j++) {
						sb.append("R");
					}
				}
				else {
					for(int j=0; j<C-1; j++) {
						sb.append("L");
					}
				}
				if(i != R) sb.append("D");
			}
		}
		else {
			for(int j=1; j<=C; j++) {
				if(j%2 == 1) {
					for(int i=0; i<R-1; i++	) {
						sb.append("D");
					}
				}
				else {
					for(int i=0; i<R-1; i++	) {
						sb.append("U");
					}
				}
				if(j!=C) sb.append("R");
			}
		}
	}
}