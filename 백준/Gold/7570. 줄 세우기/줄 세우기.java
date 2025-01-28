/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, dp[], maxLISLen=1;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_7570_줄세우기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1]; // dp[i] = i로 끝나는 LIS길이
        Arrays.fill(dp, 0);
        st = new StringTokenizer(br.readLine());

        for(int i=1; i <= N; i++){
            int n = Integer.parseInt(st.nextToken());
            dp[n] = dp[n-1] + 1;
            maxLISLen = Math.max(maxLISLen, dp[n]);
        }
        bw.write(String.valueOf(N - maxLISLen));
        bw.flush();
        bw.close();
        br.close();
    }
}
