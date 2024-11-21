/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	
	class Person{
		int r, c, key, cnt;
		Person(int r, int c, int key, int cnt) {
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}
	
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, M, res;
	static char board[][];
	static boolean visited[][][];
	static int[] dr = {0, -1, 0, 1}, dc = {-1, 0, 1, 0};
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N+2][M+2];
		visited = new boolean[N+2][M+2][1<<(6)];
		boolean flag = false; // 0이 있는지 체크
		for(int i=0; i<N+2; i++) {
			for(int j=0; j<M+2; j++) {
				board[i][j] = '#';
			}
		}
		Person p = new Person(1, 1, 0, 0);
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				board[i][j] = s.charAt(j-1);
				if (board[i][j] == '0') {
					p.r = i;
					p.c = j;
					flag = true;
				}
			}
		}
		
		if(!flag) {
			System.out.println(-1);
			return;
		}
		res = 0;
		bfs(p);

		bw.write(String.valueOf(res));
		bw.flush();
		bw.close();
		br.close();
	}

	private void bfs(Person p) {
		Queue<Person> queue = new LinkedList<>();
		Person start = p;
		visited[start.r][start.c][start.key] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Person curr = queue.poll();
			for(int k=0; k<4; k++) {
				int nr = curr.r + dr[k];
				int nc = curr.c + dc[k];
				char square = board[nr][nc];
			 
				if(visited[nr][nc][curr.key]) continue;
				if(square == '#') continue;
				
				Person next = new Person (nr, nc, curr.key, curr.cnt);
				
				if(square == '.' || square == '0') {
					next.cnt++;
					visited[nr][nc][next.key] = true;
					queue.offer(next);
				} else if(square >= 'a' && square <= 'f') {
					next.key |= 1 << (square - 'a');
					next.cnt++;
					visited[nr][nc][next.key] = true;
					queue.offer(next);
				} else if(square >= 'A' && square <= 'F') {
					if((next.key & 1 << (square - 'A')) != 0) {
						next.cnt++;
						visited[nr][nc][next.key] = true;
						queue.offer(next);
					}
				} else if(square == '1') {
					res = next.cnt + 1;
					return;
				}
			}
		}
		res = -1;
	}
}