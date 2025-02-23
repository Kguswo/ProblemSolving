/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, A[], B[], dp[][];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1727_커플만들기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1];
        B = new int[M+1];
        dp = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j <= M; j++) {
            dp[0][j] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, 1, N+1);
        Arrays.sort(B, 1, M+1);

        dp[0][0] = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                // 이번에 양쪽 수 맞을때 최대한 많이 매칭 (정렬해서 최적 가정)
                if(i == j) dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + Math.abs(A[i] - B[j]));

                // 남자 > 여자
                else if(i > j) dp[i][j] = Math.min(dp[i][j],
                        Math.min(dp[i-1][j], // 이번에 선택안함
                                dp[i-1][j-1] + Math.abs(A[i] - B[j]))); // 이번커플매칭
                // 여자 > 남자
                else dp[i][j] = Math.min(dp[i][j],
                            Math.min(dp[i][j-1], // 이번에 선택안함
                                    dp[i-1][j-1] + Math.abs(A[i] - B[j]))); // 이번커플매칭
            }
        }

        System.out.println(dp[N][M]);
        bw.flush();
        bw.close();
        br.close();
    }
}