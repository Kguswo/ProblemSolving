/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Solution {
    class Cell implements Comparable<Cell> {
        int r, c, energy, time, type;
        public Cell(int r, int c, int energy, int time, int type) {
            this.r = r;
            this.c = c;
            this.energy = energy;
            this.time = time;
            this.type = type; // 0:비활성, 1:활성, 2:죽음
        }

        @Override
        public int compareTo(Cell o){
            return o.energy - this.energy;
        }

    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, M, K;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        new Solution().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/SWEA_5653_줄기세포배양/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int maxSize = Math.max(N, M) + K * 2;
            Cell[][] board = new Cell[maxSize][maxSize];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    int energy = Integer.parseInt(st.nextToken());
                    if(energy > 0) board[i+K][j+K] = new Cell(i+K, j+K, energy, 0, 0);
                }
            }
            for(int t=0; t<K; t++){
                List<Cell> growingCells = new ArrayList<Cell>();
                for(int i=0; i<maxSize; i++){
                    for(int j=0; j<maxSize; j++){
                        if(board[i][j] == null || board[i][j].type == 2) continue;

                        Cell currCell = board[i][j];
                        currCell.time++;

                        if(currCell.type == 0 && currCell.time == currCell.energy){
                            currCell.type++;
                            currCell.time = 0;
                        }

                        if(currCell.type == 1) {
                            if(currCell.time == 1){
                                for(int k=0; k<4; k++){
                                    int nr = currCell.r + dr[k];
                                    int nc = currCell.c + dc[k];
                                    if(board[nr][nc] == null) {
                                        growingCells.add(new Cell(nr, nc, currCell.energy, 0, 0));
                                    }
                                }
                            }
                            if(currCell.time == currCell.energy) currCell.type++;
                        }
                    }
                }
                Collections.sort(growingCells);
                for(Cell c : growingCells){
                    if(board[c.r][c.c] == null) board[c.r][c.c] = c;
                }
            }

            int res = 0;
            for(int i=0; i<maxSize; i++){
                for(int j=0; j<maxSize; j++){
                    if(board[i][j] != null && board[i][j].type != 2) res++;
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}