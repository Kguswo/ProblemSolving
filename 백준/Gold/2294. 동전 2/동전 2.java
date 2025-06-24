/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n, k;
    static int[] v, dp;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2294_동전2/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        v = new int[n];
        for(int i=0; i<n; i++){
            v[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[100001];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<100001; i++){
            for(int v : v){
                if(i-v >= 0 && dp[i-v] != -1){
                    if(dp[i] == -1) dp[i] = dp[i-v] + 1;
                    else dp[i] = Math.min(dp[i], dp[i-v] + 1);
                }
            }
        }

        System.out.println(dp[k]);

        bw.flush();
        bw.close();
        br.close();
    }
}