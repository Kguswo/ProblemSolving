import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int board[][] = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) board[i][j] = 0;
                else board[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int[] f : fares){
            board[f[0]][f[1]] = f[2];
            board[f[1]][f[0]] = f[2];
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(board[i][k] != Integer.MAX_VALUE && board[k][j] != Integer.MAX_VALUE){
                        if(board[i][j] > board[i][k] + board[k][j]) board[i][j] = board[i][k] + board[k][j];
                    }
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int node=1; node<=n; node++){
            res = Math.min(res, board[s][node] + board[node][a] + board[node][b]);
        }
        
        return res;
    }
}