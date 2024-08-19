import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, map[][], dp[][];
	public static void main(String[] args) throws IOException {
		// br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][(1<<N)];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 1<<N; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(TSP( 0, 1));;
		
	}

	private static int TSP(int start, int visited) {
		if(visited == (1<<N) - 1) {
			if(map[start][0] != 0) {
				return map[start][0];
			}
			else return 987654321;
		}

		if(dp[start][visited]!= -1) return dp[start][visited];
		dp[start][visited] = 987654321;
		for(int i = 0; i < N; i++) {
			if(map[start][i] == 0 || (visited & (1<<i)) !=0) continue;

			int value = TSP(i, visited | (1<<i))+ map[start][i];
			dp[start][visited] = Math.min(dp[start][visited],  value );
		}
		return dp[start][visited];
	}
}