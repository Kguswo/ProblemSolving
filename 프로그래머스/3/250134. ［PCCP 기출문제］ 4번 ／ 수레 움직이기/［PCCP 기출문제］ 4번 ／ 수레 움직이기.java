import java.util.*;

class Solution {
    int n, m;
    int res;
    int[] redStart, blueStart, redEnd, blueEnd = new int[2];
    int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    int[][] board;
    boolean[][] redVisited, blueVisited;
    public int solution(int[][] maze) {
        this.board = maze;
        this.n = maze.length;
        this.m = maze[0].length;
        this.res = Integer.MAX_VALUE;
        
        this.redStart = new int[2];
        this.blueStart = new int[2];
        this.redEnd = new int[2];
        this.blueEnd = new int[2];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1){
                    redStart[0] = i;
                    redStart[1] = j;
                }
                else if(board[i][j] == 2) {
                    blueStart[0] = i;
                    blueStart[1] = j;
                }
                else if(board[i][j] == 3) {
                    redEnd[0] = i;
                    redEnd[1] = j;
                }
                else if(board[i][j] == 4) {
                    blueEnd[0] = i;
                    blueEnd[1] = j;
                }
                else continue;
            }
        }
        
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];
        redVisited[redStart[0]][redStart[1]] = true;
        blueVisited[blueStart[0]][blueStart[1]] = true;
        
        dfs(redStart[0], redStart[1], blueStart[0], blueStart[1], 0);
        
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    private void dfs(int rr, int rc, int br, int bc, int count) {
        if(rr == redEnd[0] && rc == redEnd[1] && br == blueEnd[0] && bc == blueEnd[1]) {
            res = Math.min(res, count);
            return;
        }
        
        List<int[]> red_candis = new ArrayList<>();
        List<int[]> blue_candis = new ArrayList<>();
        boolean redSkip = false;
        boolean blueSkip = false;
        
        if(rr == redEnd[0] && rc == redEnd[1]) {
            red_candis.add(new int[]{rr, rc});
            redSkip = true;
        }
        else {
            for(int k=0; k<4; k++) {
                int nrr = rr + dr[k];
                int nrc = rc + dc[k];
                red_candis.add(new int[]{nrr, nrc});
            }
        }
        
        if(br == blueEnd[0] && bc == blueEnd[1]) {
            blue_candis.add(new int[]{br, bc});
            blueSkip = true;
        }
        else {
            for(int k=0; k<4; k++) {
                int nbr = br + dr[k];
                int nbc = bc + dc[k];
                blue_candis.add(new int[]{nbr, nbc});
            }
        }
        
        for(int[] red : red_candis) {
            for(int[] blue : blue_candis) {
                if(red[0] == blue[0] && red[1] == blue[1]) continue;
                
                if(!redSkip) {
                    if(!isValid(red[0], red[1])) continue;
                    if(board[red[0]][red[1]] == 5) continue;
                    if(redVisited[red[0]][red[1]]) continue;
                }
                
                if(!blueSkip) {
                    if(!isValid(blue[0], blue[1])) continue;
                    if(board[blue[0]][blue[1]] == 5) continue;
                    if(blueVisited[blue[0]][blue[1]]) continue;
                }
                
                // 위치 바뀔때도 차단
                if(red[0] == br && red[1] == bc && blue[0] == rr && blue[1] == rc) continue;
                
                if(!redSkip) redVisited[red[0]][red[1]] = true;
                if(!blueSkip) blueVisited[blue[0]][blue[1]] = true;
                
                dfs(red[0], red[1], blue[0], blue[1], count+1);
                
                if(!redSkip) redVisited[red[0]][red[1]] = false;
                if(!blueSkip) blueVisited[blue[0]][blue[1]] = false;
            }
        }
    }
    
    private boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}