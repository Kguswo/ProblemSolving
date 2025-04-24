/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
//    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0};
    static int[][] board, info;
    static String[][] order;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_17780_새로운게임/input.txt")));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N+2][N+2];
        info = new int[K][3];
        order = new String[N+2][N+2];
        for(int i=0; i<N+2; i++) {
            board[0][i] = 2;
            board[N+1][i] = 2;
            board[i][0] = 2;
            board[i][N+1] = 2;
        }
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken()) - 1;

            order[info[i][0]][info[i][1]] = String.valueOf(i);
        }

        int cnt = 0;
        boolean flag = false;
        for(int t=1; t<=1000; t++){
            cnt = t;

            for(int i=0; i<K; i++){
                int cr = info[i][0];
                int cc = info[i][1];

                if(order[cr][cc] == null || Integer.valueOf(order[cr][cc].charAt(0) - '0') != i) continue;

                int dir = info[i][2];

                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                int color = board[nr][nc];

                if(color == 0){ // white
                    // next + curr(normal 순서)
                    String currOrder = order[cr][cc];
                    String nextOrder = order[nr][nc] == null ? "" : order[nr][nc];
                    sb = new StringBuilder();
                    order[cr][cc] = null;
                    order[nr][nc] = sb.append(nextOrder).append(currOrder).toString();

                    if(order[nr][nc].length() >= 4) {
                        flag = true;
                        break;
                    }

//                    info[i][0] = nr;
//                    info[i][1] = nc;
                    // 말위치 이동 (전부)
                    updatePos(currOrder, nr, nc);

                }
                else if(color == 1){ // red
                    // next + curr(reversed 순서)
                    String currOrder = order[cr][cc];
                    String nextOrder = order[nr][nc] == null ? "" : order[nr][nc];
                    sb = new StringBuilder();
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(currOrder).reverse();
                    order[cr][cc] = null;
                    order[nr][nc] = sb.append(nextOrder).append(tmp).toString();

                    if(order[nr][nc].length() >= 4) {
                        flag = true;
                        break;
                    }

                    updatePos(currOrder, nr, nc);
                }
                else if(color == 2){ // blue
                    //info dir바꾸기
                    int newDir = -1;
                    if(dir == 0 || dir == 1){
                        newDir = 1 - dir;
                        info[i][2] = newDir;
                    }
                    else if(dir == 2 || dir == 3){
                        newDir = 5 - dir;
                        info[i][2] = newDir;
                    }

                    int oppositeR = cr + dr[newDir];
                    int oppositeC = cc + dc[newDir];

                    // 반대로 갈 위치도 파랑이면 방향만변경
                    if(board[oppositeR][oppositeC] == 2) continue;

                    // next + curr
                    String currOrder = order[cr][cc];
                    String nextOrder = order[oppositeR][oppositeC] == null ? "" : order[oppositeR][oppositeC];
                    sb = new StringBuilder();

                    //반대칸 색깔체크
                    if(board[oppositeR][oppositeC] == 0){ // white
                        order[cr][cc] = null;
                        order[oppositeR][oppositeC] = sb.append(nextOrder).append(currOrder).toString();
                    }
                    else if(board[oppositeR][oppositeC] == 1){ // red
                        StringBuilder tmp = new StringBuilder();
                        tmp.append(currOrder).reverse();
                        order[cr][cc] = null;
                        order[oppositeR][oppositeC] = sb.append(nextOrder).append(tmp).toString();
                    }

                    if(order[oppositeR][oppositeC].length() >= 4) {
                        flag = true;
                        break;
                    }

                    updatePos(currOrder, oppositeR, oppositeC);
                }
            }
            if(flag) break;
        }

        int res = flag ? cnt : -1;
        System.out.println(res);
        br.close();
    }

    private static void updatePos(String order, int nr, int nc){
        for(int j = 0; j < order.length(); j++) {
            int idx = Integer.valueOf(order.charAt(j)-'0');

            info[idx][0] = nr;
            info[idx][1] = nc;
        }
    }
}