import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M, wallr1, wallr2, wallr3, wallc1, wallc2, wallc3, notsafearea, count;
	static int maxSafeCount = Integer.MIN_VALUE;
	static int[][] board;
	static boolean visited[][];
	static List<int[]> makewall, virus;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));
		
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		makewall = new ArrayList<int[]>();
		virus = new ArrayList<int[]>();

		for(int r=0; r<N+2; r++) {
			for(int c=0; c<M+2; c++) {
				board[r][c]=1;
			}
		}
		
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<M+1; c++) {
				board[r][c]=sc.nextInt();
			}
		}
		
//		for(int r=0; r<N+2; r++) {
//			for(int c=0; c<M+2; c++) {
//				System.out.print(board[r][c] + " ");
//			}
//			System.out.println();
//		}
		
		for(int r=1; r<N+1; r++) {
			for(int c=1; c<M+1; c++) {
				if(board[r][c]==2) virus.add(new int[] {r, c});
				else if(board[r][c]==0) makewall.add(new int[] {r, c});
			}
		}
		//벽 세웠을 때 비안전지대 개수세기
		notSafeArea(board);
		
		for(int k1 = 0; k1<makewall.size()-2; k1++) {
			wallr1 = makewall.get(k1)[0];
			wallc1 = makewall.get(k1)[1];
			for(int k2 = k1+1; k2<makewall.size()-1; k2++) {
				wallr2 = makewall.get(k2)[0];
				wallc2 = makewall.get(k2)[1];
				for(int k3 = k2+1; k3<makewall.size(); k3++) {
					wallr3 = makewall.get(k3)[0];
					wallc3 = makewall.get(k3)[1];
					// 여기서 벽 3개 세우고 bfs돌리기
					add3Walls(wallr1, wallc1, wallr2, wallc2, wallr3, wallc3);
					// BFS진행 + 바이러스 다 퍼지면 바이러스 퍼진 개수 세기
					count = 0;
					bfs(board);
					maxSafeCount = Math.max(maxSafeCount, N*M-(notsafearea+3)-count);
					//원상복구
					restoreBoard(wallr1, wallc1, wallr2, wallc2, wallr3, wallc3);
				}
			}
		}
		System.out.println(maxSafeCount);		
	}
	static void bfs(int[][] map) { // 바이러스 퍼뜨리기
		count = 0;
	    visited = new boolean[N+2][M+2];

		Queue<int[]> queue = new LinkedList<int[]>();
		for(int[] v : virus) {
			queue.add(v);
			visited[v[0]][v[1]] = true;
		}
		
		while(!queue.isEmpty()) {
			int current[] = queue.poll();
			int currentr = current[0];
			int currentc = current[1];
			
			for(int idx = 0; idx <=3; idx++) {
				int newr = currentr + dr[idx];
				int newc = currentc + dc[idx];
				if(map[newr][newc]==0 && visited[newr][newc]==false) {
					queue.add(new int[] {newr, newc});
					visited[newr][newc] = true;
					count++;
				}		
			}
		}
		
	}
	static void add3Walls(int r1, int c1, int r2, int c2, int r3, int c3) {
		board[r1][c1] = 1;
		board[r2][c2] = 1;
		board[r3][c3] = 1;
	}	
	static void restoreBoard(int r1, int c1, int r2, int c2, int r3, int c3) { // 벽 3개 세우기
		board[r1][c1] = 0;
		board[r2][c2] = 0;
		board[r3][c3] = 0;
	}
	static void notSafeArea(int[][] map) {
		notsafearea=0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<M+1; j++) {
				if(map[i][j]!=0) {
					notsafearea++;
				}
			}
		}
	}	
}