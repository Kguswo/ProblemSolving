/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Node implements Comparable<Node>{
        int r, c, h;
        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

        public int compareTo(Node o) {
            return this.h - o.h;
        }
    }

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
    static int N, M;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {

        fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();

        int[][] board = new int[N][M];
        int[][] dp = new int[N][M];
        dp[N-1][M-1] = 1;

        PriorityQueue<Node> nodes = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = fr.nextInt();
                board[i][j] = num;
                nodes.add(new Node(i, j, num));
            }
        }

        while(!nodes.isEmpty()) {
            Node curr = nodes.poll();

            for(int k=0; k<4; k++) {
                int nr = curr.r + dr[k];
                int nc = curr.c + dc[k];
                if(isValid(nr, nc)){
                    if(isLow(curr.h, board[nr][nc])){

                        dp[nr][nc] += dp[curr.r][curr.c];
                    }
                }
            }
        }

//        for(int i=0; i<N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(dp[0][0]);
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static boolean isLow(int curr, int next){
        return curr < next;
    }
}