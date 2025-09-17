import java.util.*;

class Solution {
    static int n, m, res;
    static int [][] XOR;
    static boolean isValidRes = false;
    public int solution(int[][] beginning, int[][] target) {
        res = Integer.MAX_VALUE;
        n = beginning.length;
        m = beginning[0].length;
        XOR = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                XOR[i][j] = beginning[i][j] ^ target[i][j];
            }
        }
        
        for(int comb=0; comb<(1<<m); comb++){
            check(comb);
        }
        
    
        return isValidRes ? res : -1;
    }
    
    private void check(int comb){
        int[][] makeZero = new int[n][m];
        for(int a=0; a<n; a++){
            makeZero[a] = Arrays.copyOf(XOR[a], m);
        }
            
        int cnt = 0;
            
        for(int j=0; j<m; j++){
            if(((1<<j) & comb) != 0){ // 뒤집기조건
                cnt++;
                for(int i=0; i<n; i++){
                    makeZero[i][j] = 1-makeZero[i][j];
                }
            }
        }
            
        for(int i=0; i<n; i++){
            if(makeZero[i][0] == 1){
                cnt++;
                for(int j=0; j<m; j++){
                    makeZero[i][j] = 1-makeZero[i][j];
                }
            }
        }
            
        boolean flag = true;
        outer : for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(makeZero[i][j] != 0) {
                    flag = false;
                    break outer;
                }
            }
        }
        
        if(flag) {
            res = Math.min(res, cnt);
            if(!isValidRes) isValidRes = true;
        }
        
        // for(int i=0; i<n; i++){
        //     System.out.println(Arrays.toString(makeZero[i]));
        // }
        // System.out.println(cnt);
    }
}