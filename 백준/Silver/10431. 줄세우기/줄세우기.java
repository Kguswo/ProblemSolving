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
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        fr = new FastReader();
        int T = fr.nextInt();
        while (T-- > 0) {
            List<Integer> height = new ArrayList<>();
            int TC = fr.nextInt();
            sb.append(TC).append(" ");

            int cnt = 0;
            for(int i = 1; i <= 20; i++) {
                int h = fr.nextInt();
                for(int j=height.size()-1; j>=0; j--) {
                    if(height.get(j) > h) cnt++;
                    else break;
                }
                height.add(h);
                Collections.sort(height);
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }
}