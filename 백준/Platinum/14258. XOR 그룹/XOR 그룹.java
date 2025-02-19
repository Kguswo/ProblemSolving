/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Cell implements Comparable<Cell> {
        int r, c, val;
        public Cell(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }

        @Override
        public int compareTo(Cell o) {
            return o.val - this.val;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static long res;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, 1, -1};
    static int[] parent; // parent[i] = i값의 대표
    static long[] XOR; // XOR[px] = 대표px그룹의 XOR값
    static int[][] board;
    static boolean[][] visited;
    static Cell[] cells;
    static FastReader fr;
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

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        board = new int[N][M];
        visited = new boolean[N][M];

        parent = new int[1000001];
        XOR = new long[1000001];
        for(int i=0; i< parent.length; i++){
            parent[i] = i;
        }

        cells = new Cell[N*M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                board[i][j] = fr.nextInt();
                cells[i*M + j] = new Cell(i, j, board[i][j]);
            }
        }
        Arrays.sort(cells);

        long sum = 0;
        for(Cell c : cells) {
            int currR = c.r, currC = c.c;
            int currVal = c.val;

            visited[currR][currC] = true;
            XOR[currVal] = currVal;
            sum += currVal;

            for(int k=0; k<4; k++) {
                int nextR = currR + dr[k];
                int nextC = currC + dc[k];
                if(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && visited[nextR][nextC]) {
                    int nextVal = board[nextR][nextC];

                    int px = find(currVal);
                    int py = find(nextVal);

                    // 부모가 다르면 병합해야함
                    if(px != py){
                        sum -= XOR[px];
                        sum -= XOR[py];

                        union(currVal, nextVal);

                        sum += XOR[find(currVal)];
                    }
                }
            }
            res = Math.max(sum, res);
        }
        System.out.println(res);
    }

    public int find(int x){
        if(parent[x] != x) return parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py) return;

        if(px < py){
            parent[py] = px;
            XOR[px] ^= XOR[py];
        }
        else{
            parent[px] = py;
            XOR[py] ^= XOR[px];
        }
    }
}