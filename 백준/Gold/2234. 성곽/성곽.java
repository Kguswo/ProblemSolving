/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, board[][];
    static int roomCnt=0, maxRoomSize=Integer.MIN_VALUE, maxRoomSizeWithBreak=Integer.MIN_VALUE;
    static int[] dr = {0, -1, 0, 1}, dc = {-1, 0, 1, 0};
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2234_성곽/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N+2][M+2];
        visited = new boolean[N+2][M+2];

        // edge padding
        for(int i = 0; i < N+2; i++){
            board[i][0] = -1;
            board[i][M+1] = -1;
        }
        for(int i = 0; i < M+2; i++){
            board[0][i] = -1;
            board[N+1][i] = -1;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 이 성에 있는 방의 개수
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(!visited[i][j]){
                    int size = bfs(i, j);
                    roomCnt++;
                    maxRoomSize = Math.max(maxRoomSize, size);
                }
            }
        }
        sb.append(roomCnt).append("\n");

        // 2. 가장 넓은 방의 넓이
        sb.append(maxRoomSize).append("\n");

        maxRoomSizeWithBreak = 0;
        // 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
        // 특정 칸에서 사방탐색해서 벽있으면 부숴서 최대 넓이
        visited = new boolean[N+2][M+2];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                int size = breakWall(i, j);
                maxRoomSizeWithBreak = Math.max(maxRoomSizeWithBreak, size);
            }
        }
        sb.append(maxRoomSizeWithBreak).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private int bfs(int i, int j) {
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currWall = board[curr[0]][curr[1]];

            for(int k=0; k<4; k++){
                int[] next = new int[] {curr[0] + dr[k], curr[1] + dc[k]};
                int nextWall = board[next[0]][next[1]];

                if(nextWall != -1 && !visited[next[0]][next[1]] && checkDir(k, currWall)){
                    queue.offer(next);
                    visited[next[0]][next[1]] = true;
                    size++;
                }
            }
        }
        return size;
    }

    private boolean checkDir(int dir, int curr) { // 이동 가능하면 true
        return (curr & (1<<dir)) == 0;
    }

    private int breakWall(int i, int j) {
        int totalSize = 0;
        int currWall = board[i][j];

        for(int r = 0; r < N+2; r++) {
            Arrays.fill(visited[r], false);
        }

        for(int k=0; k<4; k++){
            int[] next = new int[] {i + dr[k], j + dc[k]};
            int nextWall = board[next[0]][next[1]];
            if(nextWall != -1 && !checkDir(k, currWall)){

                // 벽 부수고 크기재고 원상복구
                board[i][j] &= ~(1<<k);
                if(k==0) board[next[0]][next[1]] &= ~(1<<2);
                else if(k==1) board[next[0]][next[1]] &= ~(1<<3);
                else if(k==2) board[next[0]][next[1]] &= ~(1<<0);
                else board[next[0]][next[1]] &= ~(1<<1);

                totalSize = Math.max(totalSize, bfs(i, j));

                board[i][j] |= (1<<k);
                if(k==0) board[next[0]][next[1]] |= (1<<2);
                else if(k==1) board[next[0]][next[1]] |= (1<<3);
                else if(k==2) board[next[0]][next[1]] |= (1<<0);
                else board[next[0]][next[1]] |= (1<<1);
            }
        }
        return totalSize;
    }
}