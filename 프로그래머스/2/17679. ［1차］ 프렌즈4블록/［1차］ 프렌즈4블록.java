import java.util.*;

class Solution {
    static int N, M, res=0;
    static char[][] map;
    static Set<Integer> toBeDeleted = new HashSet<>();
    static int[] startPos = {0, 0};
    public int solution(int m, int n, String[] board) {
        N = board.length;
        M = board[0].length();
        map = new char[N][M];
        for(int i=0; i<N; i++){
            map[i] = board[i].toCharArray();
        }
        
        while(!isEnd()){
            for(int i=0; i<N-1; i++){
                for(int j=0; j<M-1; j++){
                    if(i < startPos[0]) continue;
                    else if(i==startPos[0] && j < startPos[1]) continue;
                    else{
                        if(check2by2(i, j)) {
                            toBeDeleted.add(i * M + j);
                            toBeDeleted.add(i * M + j+1);
                            toBeDeleted.add((i+1) * M + j);
                            toBeDeleted.add((i+1) * M + j+1);
                        }
                    }
                }
            }
            
            for(int pos : toBeDeleted) {
                int i = pos / M;
                int j = pos % M;
                map[i][j] = 'X';
            }
            
            res += toBeDeleted.size();
            System.out.println(toBeDeleted);
            toBeDeleted.clear();
            
            goDown();
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
        return res;
    }
    private boolean check2by2(int r, int c){
        if(map[r][c] == 'X') return false;
        return map[r][c]==map[r][c+1] && map[r][c+1]==map[r+1][c] && map[r+1][c]==map[r+1][c+1];
    }
    
    private boolean isEnd(){
        for(int i=0; i<N-1; i++){
            for(int j=0; j<M-1; j++){
                if(check2by2(i, j)) {
                    startPos[0] = i;
                    startPos[1] = j;
                    return false;
                }
            }
        }
        return true;
    }
    
    private void goDown(){
        for(int j=0; j<M; j++) {
            for(int i=N-2; i>=0; i--) {
                for(int k=i; k<N-1; k++) {
                    if(map[k][j] != 'X' && map[k+1][j] == 'X') {
                        swap(k, j);
                    }
                }
            }
        }
    }
    
    private void swap(int i, int j){
        char tmp = map[i][j];
        map[i][j] = map[i+1][j];
        map[i+1][j] = tmp;
    }
}