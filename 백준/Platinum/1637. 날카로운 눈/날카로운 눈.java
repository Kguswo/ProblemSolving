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

    static class FastWriter {
        private final BufferedOutputStream bos;

        public FastWriter() {
            this.bos = new BufferedOutputStream(System.out);
        }

        public void print(Object object) throws IOException {
            bos.write(object.toString().getBytes());
        }

        public void println(Object object) throws IOException {
            print(object);
            bos.write('\n');
        }

        public void flush() throws IOException {
            bos.flush();
        }
    }
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long res;
    static boolean flag = false;
    static int[][] board; // [A, C, B] 저장
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        
        N = fr.nextInt();
        board = new int[N][3];
        for(int i=0; i<N; i++) {
            board[i][0] = fr.nextInt();
            board[i][1] = fr.nextInt();
            board[i][2] = fr.nextInt();
        }
        
        long left = 1;
        long right = 2147483647;

        while(left<=right) {
            long mid = left + (right - left)/2;
            long cnt = getCnt(mid);

            if(cnt % 2 == 0) left = mid + 1;
            else {
                res = mid;
                right = mid - 1;
                if(!flag) flag = true;
            }
        }

        if(!flag) fw.println("NOTHING");
        else {
            long ans = getCnt(res) - getCnt(res-1);
            fw.print(res);
            fw.print(" ");
            fw.println(ans);
        }
        fw.flush();
    }

    private long getCnt(long mid) { // mid보다 작거나 같은 수들의 총 개수
        if(mid < 1) return 0;

        long sum = 0;

        long A, B, C;
        for(int i=0; i<N; i++){
            A = board[i][0];
            C = board[i][1];
            B = board[i][2];
            if(mid < A) continue;
            if(mid > C) sum += (C-A)/B + 1;
            else sum += (mid-A)/B + 1;
        }
        return sum;
    }
}
