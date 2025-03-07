import java.util.*;

class Solution {
    static int N, M, max=Integer.MIN_VALUE, bfsCnt=1;
    static int[] dr = {0, -1, 0, 1}, dc = {-1, 0, 1, 0}; // 좌 상 우 하
    static int[][][] board;
    static int[][] visited;
    static int[][] nextDirs;
    public int solution(int[][] grid) {
        int res = 0;
        N = grid.length;
        M = grid[0].length;
        
        board = new int[N][M][2];
        visited = new int[N][M];
        nextDirs = new int[2][3]; // [r, c, nextState]
        
        // 각 칸마다 2개의 삼각형이 존재
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // "/" 모양 : 1
                if(grid[i][j] == 1){
                    board[i][j][0] = 1;
                    board[i][j][1] = 2;

                }
                // "\"모양 : -1
                else{
                    board[i][j][0] = -1;
                    board[i][j][1] = -2;
                }
            }
        }
                
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<2; k++){
                    if(visited[i][j] == 0){
                        // System.out.println("시작점 : " + i + " , " + j + " , " + "방향 : " + k);
                        int cnt = bfs(i, j, k, grid, bfsCnt++);
                        if(cnt > max) max = cnt;
                    }
                }
            }
        }
        return max;
    }
    
    // bfs 메서드
    private static int bfs(int r, int c, int pos, int[][] grid, int bfsId){
        int cnt = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {r, c, pos});

        visited[r][c] = bfsId;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currState = board[curr[0]][curr[1]][curr[2]];
            
            int idx = getNext(curr[0], curr[1], currState, grid);
            
            for(int i=0; i<idx; i++){
                int nextR = nextDirs[i][0];
                int nextC = nextDirs[i][1];
                int nextState = nextDirs[i][2]; // -2, -1, 1, 2
                int nextP = (int) Math.abs(nextState) %2 == 1 ? 0 : 1; // 0 or 1
                
                if(!isValid(nextR, nextC)) continue;
                
                if(visited[nextR][nextC] == bfsId) continue;
                
                visited[nextR][nextC] = bfsId;
                queue.offer(new int[] {nextR, nextC, nextP});
                cnt++;
            }
            
        }
        // System.out.println("cnt : " + cnt);
        return cnt;
    }
    
    private static int getNext(int r, int c, int state, int[][] grid){
        int dirCnt = 0;
        
        // 4가지 종류의 삼각형에 대해 다음 방향을 결정
            if(state == 1){ // 좌, 상
                int nextR = r + dr[0];
                int nextC = c + dc[0];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==1 ? 2 : -2;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
                
                nextR = r + dr[1];
                nextC = c + dc[1];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==1 ? 2 : -1;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
                
            }
            else if(state == 2){ // 우, 하
                int nextR = r + dr[2];
                int nextC = c + dc[2];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==1 ? 1 : -1;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
                
                nextR = r + dr[3];
                nextC = c + dc[3];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==1 ? 1 : -2;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
            }
            else if(state == -1){ // 좌, 하
                int nextR = r + dr[0];
                int nextC = c + dc[0];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==-1 ? -2 : 2;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
                
                nextR = r + dr[3];
                nextC = c + dc[3];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==-1 ? -2 : 1;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
            }
            else{ // -2, 상, 우
                int nextR = r + dr[1];
                int nextC = c + dc[1];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==-1 ? -1 : 2;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
                
                nextR = r + dr[2];
                nextC = c + dc[2];
                if(isValid(nextR, nextC)){
                    nextDirs[dirCnt][0] = nextR;
                    nextDirs[dirCnt][1] = nextC;
                    int nextState = grid[nextR][nextC]==-1 ? -1 : 1;
                    nextDirs[dirCnt][2] = nextState;
                    dirCnt++;
                }
            }
        return dirCnt;
    }
                       
    private static boolean isValid(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}