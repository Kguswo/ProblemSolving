/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long N;
    static int M;
    static long[] A, B;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15948_간단한문제/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new long[M];
        B = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        solve(N, M, 0);

        for(int i=0; i<M; i++) {
            sb.append(String.valueOf(B[i]));
            if(i < M-1) sb.append(" ");
        }
        sb.append('\n');
        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solve(long n, int m, int k){
        if(m == 1){
            B[k] = n * A[k];
            return;
        }

        if(n%2 == 1){
            B[k] = n * A[k];
            solve((n+1)/2, m-1, k+1);
            return;
        }
        else{
            solve(n/2, m-1, k);
            B[k+m-1] = (n + (1L<<m) - 2) * A[k+m-1];
        }
    }
}