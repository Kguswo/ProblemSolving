class Solution {
    private static final int MOD = 10007;
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] hasTail = new int[n]; // 3번 모양으로 끝났는가? o
        int[] noTail  = new int[n]; // x
       
        hasTail[0] = 1;
        noTail[0] = 2;
        noTail[0] += tops[0];
        
        for(int i=1; i<n; i++){
            hasTail[i] = hasTail[i-1] + noTail[i-1] ;
            if(tops[i] == 1) noTail[i] = hasTail[i-1]*2 + noTail[i-1]*3;
            else noTail[i] = hasTail[i-1]*1 + noTail[i-1]*2;
            
            hasTail[i] %= MOD;
            noTail[i] %= MOD;
        }   
        
        return (hasTail[n-1] + noTail[n-1])%MOD;
    }
}