import java.util.*;

class Solution {
    int n, m;
    List<String[]> sculptures = new ArrayList<>();
    int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        m = game_board[0].length;
        boolean[][] visited_table = new boolean[n][m];
        
        // 테이블 블럭 수집
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited_table[i][j] && table[i][j] == 1) {
                    List<int[]> tmp = bfs(table, visited_table, i, j);
                    sculptures.add(makeSculptureString(tmp));
                }
            }
        }
        
        int ans = 0;
        boolean[] visited = new boolean[sculptures.size()];
        
        // game_board 돌면서 수집한 블럭 끼워보기
        boolean[][] visited_game = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited_game[i][j] && game_board[i][j] == 0) {
                    List<int[]> targets = bfs(game_board, visited_game, i, j);
                    String hole = makeSculptureString(targets)[0];
                    for (int a=0; a<visited.length; a++) {
                        if (visited[a]) continue;
                        boolean flag = false;
                        for (String s : sculptures.get(a)) {
                            if (hole.equals(s)) {
                                flag = true;
                                break;
                            }
                        }
                        
                        if (flag) {
                            visited[a] = true;
                            ans += targets.size();
                            break;
                        }
                    }
                    
                }
            }
        }
        
        return ans;
    }
    
    private List<int[]> bfs(int[][] board, boolean[][] visited, int sr, int sc) { 
        List<int[]> result = new ArrayList<>();
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {sr, sc});
        visited[sr][sc] = true;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            result.add(curr);
            
            for (int k=0; k<4; k++) {
                int nr = curr[0] + dr[k];
                int nc = curr[1] + dc[k];
                if (isValid(nr, nc) && !visited[nr][nc] && board[nr][nc] == board[sr][sc]) {
                    queue.offer(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
    
    private String[] makeSculptureString(List<int[]> cells) {
        String[] res = new String[4]; // 0, 90, 180, 270
        for (int k=0; k<4; k++) {
            // 행 오름차순, 이후 열 오름차순
            cells.sort((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            
            // 맨 앞 0,0 으로 정규화
            int bR = cells.get(0)[0];
            int bC = cells.get(0)[1];
            
            StringBuilder sb = new StringBuilder();
            for (int[] cell : cells) {
                sb.append(cell[0] - bR).append(',').append(cell[1]-bC).append('|');
            }
            res[k] = sb.toString();
            
            // 90 회전 (x,y) -> (y,-x)
            List<int[]> rotate = new ArrayList<>();
            for (int[] cell : cells) {
                rotate.add(new int[] {cell[1], -1 * cell[0]});
            }
            cells = rotate;
        }
        
        return res;
    }
}