/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int m, q, n, x;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        m = read();
        int[][] dp = new int[19][m+1];

        // f(x) 입력 받기
        for(int i = 1; i <= m; i++) {
            dp[0][i] = read();
        }

        // 희소 배열 계산
        for(int i=1; i<19; i++) {
            for(int j=1; j<=m; j++){
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        q = read();
        while(q--> 0) {
            n = read();
            x = read();

            for(int i=0; i<19; i++){
                if((n & (1<<i)) != 0) x = dp[i][x];
            }
            sb.append(x).append("\n");
        }
        System.out.println(sb);
    }
    public static int read() throws IOException {
        int n = 0;
        boolean isNegative = false;
        int c;
        while ((c = System.in.read()) <= 32) ;
        if (c == '-') {
            isNegative = true;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 32);
        return isNegative ? -n : n;
    }
}