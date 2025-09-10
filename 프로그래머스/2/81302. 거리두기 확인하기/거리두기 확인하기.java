import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    public int[] solution(String[][] places) {
        int[] res = new int[5];
        
        for(int t=0; t<5; t++){
            char[][] board = new char[5][5];
            for(int i=0; i<5; i++){
                board[i] = places[t][i].toCharArray();
            }
            boolean flag = true;
            outer: for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(board[i][j] == 'P'){
                        if(!bfs(board, i, j)) {
                            flag = false;
                            break outer;
                        }
                    }
                }
            }
            
            if(flag) res[t] = 1;
            else res[t] = 0;
        }
        
        return res;
    }
    
    private static boolean bfs(char[][] board, int r, int c){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];
        
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        
        int depth = 0;        
        while(!queue.isEmpty() && depth < 2){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                int cr = curr[0];
                int cc = curr[1];
                for(int k=0; k<4; k++){
                    int nr = cr + dr[k];
                    int nc = cc + dc[k];
                    
                    if(isValid(nr, nc) && !visited[nr][nc]){
                        char node = board[nr][nc];
                        if(node == 'X') continue;
                        else if(node == 'P') return false;
                        else if(node == 'O') {
                            queue.offer(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            depth++;
        }
        return true;
    }
    
    private static boolean isValid(int r, int c){
        return r >= 0 && r<5 && c >= 0 && c<5;
    }
}