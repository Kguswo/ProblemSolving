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
    class Flower implements Comparable<Flower>{
        int start, end;
        public Flower(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if(this.start == o.start) return o.end - this.end;
            return this.start - o.start;
        }
    }
    static FastReader fr;
    static int N, START, END, res;
    static int[] monthPrefix = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30}; // 1~11월
    static Flower[] flowers;
    static boolean flag=true; // 가능하면 true
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        fr = new FastReader();

        // m월 0일
        for(int i=1; i<monthPrefix.length; i++) {
            monthPrefix[i] += monthPrefix[i-1];
        }
//        System.out.println(Arrays.toString(monthPrefix));
        START = monthPrefix[2] + 1;
        END = monthPrefix[10] + 30;

        N = fr.nextInt();
        flowers = new Flower[N];
        int m1, d1, m2, d2;
        for(int i=0; i<N; i++) {
            m1 = fr.nextInt();
            d1 = fr.nextInt();
            m2 = fr.nextInt();
            d2 = fr.nextInt();
            flowers[i] = new Flower(monthPrefix[m1-1] + d1, monthPrefix[m2-1] + d2);
        }

        Arrays.sort(flowers);

        int currEnd = START;
        int idx = 0;
        while(currEnd <= END && flag) {
            int nextEnd = currEnd;
            while(idx < N && flowers[idx].start <= currEnd){
                if(nextEnd < flowers[idx].end){
                    nextEnd = flowers[idx].end;
                }
                idx++;
            }

            // 발전이 없음
            if(nextEnd == currEnd) flag = false;
            else {
                res++;
                currEnd = nextEnd;
            }
        }
        System.out.print(flag? res : 0);
    }
}