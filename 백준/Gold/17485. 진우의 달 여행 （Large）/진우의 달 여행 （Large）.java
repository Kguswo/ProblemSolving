/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
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
    static FastReader fr = new FastReader();
    static int N, M, prev[][], curr[][]  , res = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        N = fr.nextInt();
        M = fr.nextInt();

        prev = new int[M + 1][3];
        curr = new int[M + 1][3];
        for(int j = 0; j <= M; j++) {
            Arrays.fill(prev[j], Integer.MAX_VALUE);
            Arrays.fill(curr[j], Integer.MAX_VALUE);
        }

        for(int i=1; i<=N; i++) {
            if(i==1){
                for (int j = 1; j <= M; j++) {
                    int num = fr.nextInt();
                    for (int k = 0; k < 3; k++) {
                        prev[j][k] = num;
                    }
                }
            }
            else{
                for (int j = 1; j <= M; j++) {
                    int num = fr.nextInt();

                    int down = Math.min(prev[j][1], prev[j][2]);
                    int left = (j > 1) ? Math.min(prev[j - 1][0], prev[j - 1][2]) : Integer.MAX_VALUE;
                    int right = (j < M) ? Math.min(prev[j + 1][0], prev[j + 1][1]) : Integer.MAX_VALUE;

                    if (down != Integer.MAX_VALUE) curr[j][0] = down + num; // 밑으로 |
                    if (left != Integer.MAX_VALUE) curr[j][1] = left + num; // 왼오\방향
                    if (right != Integer.MAX_VALUE) curr[j][2] = right + num; // 오왼/ 방향
                }
                int[][] temp = prev;
                prev = curr;
                curr = temp;
                for(int j = 0; j <= M; j++) {
                    Arrays.fill(curr[j], Integer.MAX_VALUE);
                }
            }
        }

        for(int j=1; j<=M; j++) {
            for(int k=0; k<3; k++) {
                res = Math.min(res, prev[j][k]);
            }
        }
        System.out.println(res);
    }
}