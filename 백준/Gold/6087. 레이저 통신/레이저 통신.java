/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main{
    class Node implements Comparable<Node>{
        int r, c, direction, mirror;
        public Node(int r, int c, int direction, int mirror){
            this.r = r;
            this.c = c;
            this.direction = direction;
            this.mirror = mirror;
        }

        @Override
        public int compareTo(Node o){
            return this.mirror - o.mirror;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int W, H;
    static char board[][];
    static int visited[][][];
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    static List<int[]> C_List = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_6087_레이저통신/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new char[H+2][W+2];
        visited = new int[H+2][W+2][4];

        for(int i = 0; i < H+2; i++){
            Arrays.fill(board[i], '*');
            for(int j=0; j<W+2; j++){
                for(int k=0; k<4; k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i <= H; i++) {
            String str = br.readLine();
            for (int j = 1; j <= W; j++) {
                board[i][j] = str.charAt(j-1);
                if(board[i][j] == 'C') C_List.add(new int[]{i, j});
            }
        }

        int res = findMinMirror();
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private int findMinMirror() {
        int[] C_Start = C_List.get(0);
        int[] C_End = C_List.get(1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(C_Start[0], C_Start[1], -1, 0));
        for(int k=0; k<4; k++){
            visited[C_Start[0]][C_Start[1]][k] = 0;
        }

        while(!pq.isEmpty()){
            Node currNode = pq.poll();
            if(currNode.r == C_End[0] && currNode.c == C_End[1]) return currNode.mirror;

            for(int k = 0; k < 4; k++){
                int[] nextPos = new int[]{currNode.r + dr[k], currNode.c + dc[k]};
                int currMirrorCnt = currNode.mirror;

                if(board[nextPos[0]][nextPos[1]] == '*') continue;

                if(currNode.direction != -1 && currNode.direction != k) currMirrorCnt++;

                if(currMirrorCnt < visited[nextPos[0]][nextPos[1]][k]) {
                    pq.offer(new Node(nextPos[0], nextPos[1], k, currMirrorCnt));
                    visited[nextPos[0]][nextPos[1]][k] = currMirrorCnt;
                }
            }
        }
        return -1;
    }
}