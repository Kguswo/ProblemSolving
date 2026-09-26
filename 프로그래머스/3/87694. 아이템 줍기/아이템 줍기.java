import java.util.*;

class Solution {
    static int[] dr = {0, -1, 0, 1}, dc = {-1, 0, 1, 0};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[102][102];
        
        for (int i = 0; i < rectangle.length; i++) {
            int[] r = rectangle[i];
            for (int x=2*r[0]; x<=2*r[2]; x++) {
                for (int y=2*r[1]; y<=2*r[3]; y++) {
                    board[x][y] = 1;
                }
            }
        }
        
        for (int i = 0; i < rectangle.length; i++) {
            int[] r = rectangle[i];
            for (int x=2*r[0]+1; x<2*r[2]; x++) {
                for (int y=2*r[1]+1; y<2*r[3]; y++) {
                    board[x][y] = 0;
                }
            }
        }
        
        int[][] visited = new int[102][102];
        for (int i=0; i<102; i++) {
            for (int j=0; j<102; j++) {
                visited[i][j] = -1;
            }
        }
        
        int ans = bfs(board, visited, 2*characterX, 2*characterY, 2*itemX, 2*itemY);
        
        // print(visited, 24, 24);
        return ans/2;
    }
    
    private int bfs(int[][] board, int[][] visited, int cX, int cY, int iX, int iY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{cX, cY});
        visited[cX][cY] = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currDist = visited[curr[0]][curr[1]];
            
            for (int k=0; k<4; k++) {
                int nr = curr[0] + dr[k];
                int nc = curr[1] + dc[k];
                
                if (isValid(nr, nc) && visited[nr][nc] == -1 && board[nr][nc] == 1) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = currDist + 1;
                }
            }
        }
        
        return visited[iX][iY];
    }
    
    private boolean isValid(int r, int c) {
        return r >= 0 && r < 102 && c >= 0 && c < 102; 
    }
    
    // private void print(int[][] grid, int maxX, int maxY) {
    //     for (int y = maxY; y >= 0; y--) {
    //         StringBuilder sb = new StringBuilder();
    //         sb.append(String.format("%3d|", y));
    //         for (int x = 0; x <= maxX; x++) {
    //             sb.append(grid[x][y] == -1 ? "  ." : String.format("%3d", grid[x][y]));
    //         }
    //         System.out.println(sb);
    //     }
    //     System.out.println();
    // }
}