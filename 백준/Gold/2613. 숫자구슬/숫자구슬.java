import java.io.*;
import java.util.*;

public class Main {
    static int a[], sum[], dp[][], n, m;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        
        a = new int[305];
        sum = new int[305];
        dp = new int[305][305];
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + a[i];
            dp[i][1] = sum[i];
        }

        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) { // 그룹 수
            for (int j = 1; j <= n; j++) { // 구슬 수
                for (int k = 1; k <= j; k++) {
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[j - k][i - 1], sum[j] - sum[j - k]));
                }
            }
        }

        System.out.println(dp[n][m]);
        makeAns(n, m);
    }
    
    private static void makeAns(int j, int i) {  
    	if (i == 0 && j == 0) {
    		return;
    	}
    	for (int k = j; k >= 1; k--) {
    		if (Math.max(dp[j - k][i - 1], sum[j] - sum[j - k]) == dp[j][i]) {
    			makeAns(j - k, i - 1);
    			System.out.print(k + " ");
    			return;
    		}
    	}
    }
}