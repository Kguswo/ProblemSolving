import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;
    static int[] dr = {0, 0, -1, 1}, dc = {1, -1, 0, 0};
    static int[][] board, info;
    static String[][] order;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        board = new int[N+2][N+2]; // 색깔 저장
        info = new int[K][3]; // 위치 및 방향 저장
        order = new String[N+2][N+2]; // 각 칸마다 쌓여있는 말들의  
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
        //입력받기끝

        int cnt = 0;
        boolean flag = false;
        for(int t=1; t<=1000; t++){
            cnt = t;

            for(int i=0; i<K; i++){
                int cr = info[i][0];
                int cc = info[i][1];

								// 맨 아래에 있는 말이 아니면 본인의지로 이동을 못하니까 패스
                if(order[cr][cc] == null || Integer.valueOf(order[cr][cc].charAt(0) - '0') != i) continue;

                int dir = info[i][2];

                int nr = cr + dr[dir];
                int nc = cc + dc[dir];

                int color = board[nr][nc];

								// 흰색
                if(color == 0){
                
                    // next + curr(normal 순서)
                    String currOrder = order[cr][cc];
                    String nextOrder = order[nr][nc] == null ? "" : order[nr][nc];
                    sb = new StringBuilder();
                    order[cr][cc] = null;
                    order[nr][nc] = sb.append(nextOrder).append(currOrder).toString();

										// 종료조건 체크								
                    if(order[nr][nc].length() >= 4) {
                        flag = true;
                        break;
                    }

                    // 말위치 이동 (전부)
                    updatePos(currOrder, nr, nc);

                }
                
                // 빨강
                else if(color == 1){
                
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
                
                // 파랑
                else if(color == 2){
                
                    // 방향 반대로 바꾸기
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
                    if(board[oppositeR][oppositeC] == 0){ // 반대편 흰색이면
                        order[cr][cc] = null;
                        order[oppositeR][oppositeC] = sb.append(nextOrder).append(currOrder).toString();
                    }
                    else if(board[oppositeR][oppositeC] == 1){ // 반대편 빨간색이면
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
            
            // 종료조건 체크했을때 달성시 턴 종료
            if(flag) break;
        }

        int res = flag ? cnt : -1;
        System.out.println(res);
        br.close();
    }

		// 위치 업데이트 (쌓여있는 모든 말)
    private static void updatePos(String order, int nr, int nc){
        for(int j = 0; j < order.length(); j++) {
            int idx = Integer.valueOf(order.charAt(j)-'0');

            info[idx][0] = nr;
            info[idx][1] = nc;
        }
    }
}