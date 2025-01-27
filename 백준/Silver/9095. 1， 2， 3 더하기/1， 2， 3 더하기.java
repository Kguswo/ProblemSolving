/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int TC, N, dp[][];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_9095_123더하기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[3][10]; // 0-based
        // 1만쓸때
        for(int i = 0; i < 10; i++){
            dp[0][i] = 1;
        }

        // 1, 2 쓸때
        dp[1][0] = 1;
        dp[1][1] = 2;

        for(int i = 2; i < 10; i++){ // 3부터 N까지 만듬
            dp[1][i] = dp[1][i-1] + dp[1][i-2];
        }

        // 1, 2, 3 쓸때
        dp[2][0] = 1;
        dp[2][1] = 2;
        dp[2][2] = 4;
        for(int i = 3; i < 10; i++){
            dp[2][i] = dp[2][i-1] + dp[2][i-2] + dp[2][i-3];
        }

        TC = Integer.parseInt(br.readLine());

        while(TC-->0){
            N = Integer.parseInt(br.readLine());

            /*
                dp     열 :  만들숫자 - 1
                -> 인덱스    0  1  2  3  4  5  6   ... N-1
                1만사용      :  1  1  1  1           ...  1
                1, 2 사용    :           ? -> 1만 사용한 메모이제이션 값을 응요해야함
                                             N-1까지 1, 2로만 만든거에서 +1 : dp[1][i] = + dp[1][i-1]
                                             N-2까지 1, 2로만 만든거에서 +2 : dp[1][i] = + dp[1][i-2]
                                             dp[1][i] = dp[1][i-1] + dp[1][i-2]; i >= 2
                1, 2, 3 사용 : 1,2로 숫자 만드는 경우의 수를 dp 1행에 다 저장해놨어.
                                           -> 아까랑 똑같지만 3을 더하는 경우만 추가해주면 된다!
                                             N-1까지 1, 2, 3로만 만든거에서 +1 : dp[2][i] = + dp[1][i-1]
                                             N-2까지 1, 2, 3로만 만든거에서 +2 : dp[2][i] = + dp[1][i-2]
                                             N-3까지 1, 2, 3로만 만든거에서 +3 : dp[2][i] = + dp[1][i-3]
                                             dp[2][i] = dp[2][i-1] + dp[2][i-2] + dp[2][i-3]; i >= 3
                모든 경우의수를 다 따질수 있다.
             */


            bw.write(dp[2][N-1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}