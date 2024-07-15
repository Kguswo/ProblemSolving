import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int M, N, board[][], dp[][], maxL;
	public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new FileReader("input.txt"));
		st = new StringTokenizer(br.readLine());
		M = Integer.valueOf(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		dp = new int[M + 1][N + 1];
        dp[0][0] = 0;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		maxL = 0;
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
            	if(board[i-1][j-1] > 0 ) continue;
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                maxL = Math.max(maxL, dp[i][j]);
            }
        }
        System.out.println(maxL);
	}
}