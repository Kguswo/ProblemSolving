class Solution {
    static int[] dr = {-1, 0, 1, 0}, dc = {0, -1, 0, 1};
    static int res = 0;
    static int N, M;
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        N = board.length;
        M = board[0].length;
        res = dfs(board, aloc, bloc, 0);
        return res;
    }
    
    private int dfs(int[][] board, int[] aloc, int[] bloc, int order){
        // 순서 0이면 a, 1면 b
        int currR, currC;
        currR = order == 0 ? aloc[0] : bloc[0];
        currC = order == 0 ? aloc[1] : bloc[1];
        
        // 전 사람이 이기면 끝
        if(board[currR][currC] == 0 || !canMove(board, currR, currC)) return 0;
        
        int currWin = Integer.MAX_VALUE;
        int currLose = 0;
        boolean isCurrWin = false;
        
        // 지금 발판 없애기
        board[currR][currC] = 0;
        
        for(int k=0; k<4; k++){
            int nr = currR + dr[k];
            int nc = currC + dc[k];
            
            if(isValid(nr, nc) && board[nr][nc] == 1){
                int nextCnt; // 이후 나의 이동횟수
                nextCnt = order == 0 ? dfs(board, new int[] {nr, nc}, bloc, 1-order) : dfs(board, aloc, new int[] {nr, nc}, 1-order);
                
                // 다음 플레이어가 짐 -> 지금 플레이어 최대한 빨리이기기
                if(nextCnt%2 == 0){
                    currWin = Math.min(currWin, nextCnt + 1);
                    isCurrWin = true;
                } 
                // 다음 플레이어가 이김 -> 지금 플레이어 최대한 늦게지기
                else currLose = Math.max(currLose, nextCnt + 1);
            }
        }
        board[currR][currC] = 1;
        
        return isCurrWin ? currWin : currLose;
    }
    
    private static boolean canMove(int[][] board, int r, int c){
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (isValid(nr, nc) && board[nr][nc] == 1) return true;
        }
        return false;
    }
    
    private static boolean isValid(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}