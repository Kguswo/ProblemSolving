/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;

	static int W, H, K;
	static int[][] board;
	static boolean[][][] visited;
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hc = {-2, -1, 1, 2, 2, 1, -1, -2};
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		board = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
				}
			}
		}
		int res = bfs(0, 0, K);
		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private int bfs(int r, int c, int k) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(r, c, 0, 0));
		visited[r][c][0] = true;
		
		while(!queue.isEmpty()) {
			Pos curr = queue.poll();
			
			int currR = curr.r;
			int currC = curr.c;
			if(currR == H-1 && currC == W-1) return curr.mCnt;
			
			for(int idx=0; idx<4; idx++) {
				int newR = currR + dr[idx];
				int newC = currC + dc[idx];
				
				// 경계조건
				if(newR < 0 || newR >= H || newC < 0 || newC >= W) continue;
				// 방문한곳 or 장애물
                if(visited[newR][newC][curr.hCnt] || board[newR][newC] == 1) continue;
				
				if(board[newR][newC] == 0) {
					visited[newR][newC][curr.hCnt] = true;
					queue.offer(new Pos(newR, newC, curr.hCnt, curr.mCnt+1));
				}			
			}
			
			// 말 점프 가능하면 말점프
			if(curr.hCnt<k) {
				for(int idx = 0; idx<8; idx++) {
					int newR = currR + hr[idx];
					int newC = currC + hc[idx];
					
					if(newR < 0 || newR >= H || newC < 0 || newC >= W) continue;
					
                    if(visited[newR][newC][curr.hCnt+1] || board[newR][newC] == 1) continue;
				
					if(board[newR][newC] == 0) {
						visited[newR][newC][curr.hCnt+1] = true;
						queue.offer(new Pos(newR, newC, curr.hCnt+1, curr.mCnt+1));
					}
				}
			}
		}
		
		return -1;
	}
	
	static class Pos{
		int r, c;
		int hCnt; //말 점프 횟수
		int mCnt; //움직인 횟수
		
		Pos(int r, int c, int hCnt, int mCnt){
			this.r = r;
			this.c = c;
			this.hCnt = hCnt;
			this.mCnt = mCnt;
		}
	}
}
