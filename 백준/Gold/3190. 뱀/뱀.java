/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K, L, dir, res=0;
    static int[] dr = {0, -1, 1, 0, 0}, dc = {0, 0, 0, -1, 1};
    static int[][] board;
    static Map<Integer, String> dirCommand = new HashMap<>();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_3190_뱀/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N+2][N+2];
        for(int i=0; i<N+2; i++) {
            board[0][i] = -1;
            board[N+1][i] = -1;
            board[i][0] = -1;
            board[i][N+1] = -1;
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r][c] = 9;
        }

        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            dirCommand.put(t, s);
        }

        playGame();

//        // 디버깅용
//        for(int i=1; i<=N; i++) {
//            for(int j=1; j<=N; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private void playGame() {
        int dir = 4; // dr dc 인덱스 상1 하2 좌3 우4
        int[] head = new int[]{1, 1};
        int[] tail = new int[]{1, 1};
        board[head[0]][head[1]] = 4;

        while(true){
            res++;

            int[] nextHead = new int[] {head[0] + dr[dir], head[1] + dc[dir]};

            // 종료조건
            if(board[nextHead[0]][nextHead[1]] == -1) break;
            if(1 <= board[nextHead[0]][nextHead[1]] && board[nextHead[0]][nextHead[1]] <= 4) break;

            // 사과찾았는지 여부
            boolean flag = board[nextHead[0]][nextHead[1]] == 9;

            // 머리이동
            board[nextHead[0]][nextHead[1]] = dir;
            head = nextHead;

            // 사과 없을때 꼬리당기기
            if(!flag){
                int tailDir = board[tail[0]][tail[1]];
                int[] nextTail = new int[] {tail[0] + dr[tailDir], tail[1] + dc[tailDir]};
                board[tail[0]][tail[1]] = 0;
                tail = nextTail;
            }

            // 머리방향 돌리기
            if(dirCommand.containsKey(res)){
                // 시계방향 1-4-2-3-1
                if(dirCommand.get(res).equals("D")) {
                    if(dir==1) dir=4;
                    else if(dir==2) dir=3;
                    else if(dir==3) dir=1;
                    else if(dir==4) dir=2;
                }
                // 반시계방향 1-3-2-4-1
                else{
                    if(dir==1) dir=3;
                    else if(dir==2) dir=4;
                    else if(dir==3) dir=2;
                    else if(dir==4) dir=1;
                }
                board[head[0]][head[1]] = dir;
            }
        }
    }
}
