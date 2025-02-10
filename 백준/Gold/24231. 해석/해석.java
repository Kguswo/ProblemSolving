/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static final int MOD = 1000000007;
    static String str;
    static int N;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_24231_해석/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        N = str.length();

        dp = new long[N+1][N+1];
        // 빈 문자열은 1
        for(int i = 1; i <= N; i++) {
            dp[i][i-1] = 1;
        }

        for(int len = 2; len <= N; len++) {
            for(int left = 0; left <= N-len; left++) {
                int right = left + len - 1;
                // 중간에 결합법칙 성립시 경우의수 추가
                // left-mid가 () 되면 ( [(left+1) ~ (mid-1)] ) [(mid+1) ~ right] 이런형태
                for(int mid = left+1; mid <= right; mid++) {
                    if(str.charAt(left) != str.charAt(mid)) dp[left][right] = (dp[left][right] + (dp[left+1][mid-1] * dp[mid+1][right]) % MOD) % MOD;
                }
            }
        }

        System.out.println(dp[0][N-1]);
        br.close();
    }
}