/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int N, res=0;
	static int[] dr = {0, 1, 1, 1}; // 가로, 세로, 대각선\, 대각선/
	static int[] dc = {1, 0, 1, -1}; 
	static int[][] board;
	static int[][][][] dp; // [r][c][direction][changed]
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		board = new int[N+2][N+2];
		// (r, c) 위치에서 k방향으로 연속된 흑돌의 최대 길이
        dp = new int[N+2][N+2][4][2]; // direction: 0-가로, 1-세로, 2-대각선\, 3-대각선/, changed: 0-안바꿈, 1-바꿈
		List<int[]> whiteList = new ArrayList<>();

		for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 2) whiteList.add(new int[] {i, j});
            }
        }
		
		// dp 계산
        for(int i = N; i >= 1; i--) {
            for(int j = N; j >= 1; j--) {
                if(board[i][j] == 1) {
                    for(int k = 0; k < 4; k++) {
                    	int nr = i + dr[k];
                        int nc = j + dc[k];
                        if(nr >= 1 && nr <= N && nc >= 1 && nc <= N) {
                            dp[i][j][k][0] = dp[nr][nc][k][0] + 1;
                            dp[i][j][k][1] = dp[nr][nc][k][1] + 1;
                        } else {
                            dp[i][j][k][0] = 1;
                            dp[i][j][k][1] = 1;
                        }
                    }
                }
                else if(board[i][j] == 2) {
                    for(int k = 0; k < 4; k++) {
                    	int prevR = i - dr[k];
                        int prevC = j - dc[k];
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];
                        if(prevR >= 1 && prevR <= N && prevC >= 1 && prevC <= N) {
                            if(board[prevR][prevC] == 1) {
                                // 이전 방향에 흑돌이 있는 경우
                                dp[i][j][k][1] = Math.max(dp[i][j][k][1], dp[prevR][prevC][k][0] + 1);
                            }
                        }
                        
                        if(nextR >= 1 && nextR <= N && nextC >= 1 && nextC <= N) {
                            if(board[nextR][nextC] == 1) {
                                // 다음 방향에 흑돌이 있는 경우
                                dp[i][j][k][1] = Math.max(dp[i][j][k][1], dp[nextR][nextC][k][0] + 1);
                            }
                        }
                        
                        // 양쪽 모두 흑돌이 있는 경우
                        if(prevR >= 1 && prevR <= N && prevC >= 1 && prevC <= N &&
                           nextR >= 1 && nextR <= N && nextC >= 1 && nextC <= N &&
                           board[prevR][prevC] == 1 && board[nextR][nextC] == 1) {
                            dp[i][j][k][1] = dp[prevR][prevC][k][0] + dp[nextR][nextC][k][0] + 1;
                        }
                    }
                }
            }
        }
        
        
        // 최대값 찾기
        int res = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int k = 0; k < 4; k++) {
                    res = Math.max(res, Math.max(dp[i][j][k][0], dp[i][j][k][1]));
                }
            }
        }
        
        System.out.println(res);
		
		bw.flush();
		bw.close();
		br.close();
	}
}