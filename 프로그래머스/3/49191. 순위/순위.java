// sol_2 플로이드워셜

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] board = new int[n+1][n+1]; // 이기면 1 , 지면 0
        for (int[] result : results) {
            board[result[0]][result[1]] = 1;
        }
        
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    if (board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                    }
                }
            }
        }
        
        int ans = 0;
        for (int num=1; num<=n; num++) {
            int win = 0;
            int lose = 0;
            for (int i=1; i<=n; i++) {
                if (board[num][i]==1) {
                    win++;
                }
                if (board[i][num]==1) {
                    lose++;
                }
            } 
            if (win + lose == n-1) ans++;
        }
        
        return ans;
    }
}