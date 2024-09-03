import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, T, M, coins[], dp[][];
    public static void main(String[] args) throws IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
//    	br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            coins = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            M = Integer.parseInt(br.readLine());
            dp = new int[N][M + 1];
            
            for(int i = 1; i < coins.length;i++){
                dp[i][0] = 1;
            }
            
            for (int i = 0; i < N; i++) {
                dp[i][0] = 1;
                for (int j = 1; j <= M; j++) {
                    if (i > 0) dp[i][j] = dp[i - 1][j];
                    if (j-coins[i] >= 0) dp[i][j] += dp[i][j - coins[i]];
                }
            }
            System.out.println(dp[N-1][M]);
//            for (int[] arr : dp) {
//                System.out.println(Arrays.toString(arr));
//            }
        }
    }
}