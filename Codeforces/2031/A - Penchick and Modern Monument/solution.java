import java.io.*;
import java.util.*;
 
public class A {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
 
    public static void main(String[] args) throws Exception {
        new A().solution();
    }
 
    public void solution() throws Exception {
      //  br = new BufferedReader(new InputStreamReader(new FileInputStream("A.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
      br = new BufferedReader(new InputStreamReader(System.in));
 
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
 
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            int[] heights = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }
            
            int operations = calculateMinOperations(heights);
            bw.write(String.valueOf(operations));
            bw.write("
");
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    private int calculateMinOperations(int[] heights) {
        int n = heights.length;
        if (n <= 1) return 0;
 
        int operations = 0;
        int[] dp = new int[n];
        dp[n-1] = 1;
        
        for (int i = n-2; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i+1; j < n; j++) {
                if (heights[i] <= heights[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            operations = Math.max(operations, dp[i]);
        }
        
        return n - operations;
    }
}