/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, end, arr[];
    static long dp[][], res;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_5557_1학년/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new long[N][21];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N-1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        end = Integer.parseInt(st.nextToken());

        dp[1][arr[1]] = 1;
        long up, down;

        for(int i = 2; i <= N-1; i++) {
            for(int j=0; j<=20; j++) {
                up = j - arr[i] >= 0 ? dp[i-1][j - arr[i]] : 0;
                down = j + arr[i] <= 20 ? dp[i-1][j + arr[i]] : 0;

                dp[i][j] = up + down;
            }
        }

        res = dp[N-1][end];

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}