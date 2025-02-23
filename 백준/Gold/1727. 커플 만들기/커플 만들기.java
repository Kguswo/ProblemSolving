/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    public class FastReader {
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[16384];
            bufferPointer = bytesRead = 0;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, buffer.length);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
    }
    static FastReader fr;
    static int N, M, A[], B[], dp[][];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();

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

        for(int i=1; i<=N; i++) {
            A[i] = fr.nextInt();
        }
        for(int i=1; i<=M; i++) {
            B[i] = fr.nextInt();
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
//        for(int i=0; i<=N; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[N][M]);
    }
}