class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long ans=0;
        
        long left = 0;
        long right = (long) 1e15;
        
        long res = 0;
        while(left <= right){
            long mid = left + (right-left) / 2L;
            if(canBuild(a, b, g, s, w, t, mid)){
                res = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return res;
    }
    
    private static boolean canBuild(int a, int b, int[] g, int[] s, int[] w, int[] t, long mid){
        long goldW = 0; // a이상이어야함
        long silverW = 0; // b이상이어야함
        long totalW = 0; // a+b이상이어야함
            
        for(int i=0; i<w.length; i++){
            long cnt = (long) mid / (2L * (long) t[i]);
            if(mid % (2L * (long) t[i]) >= t[i]) cnt++; // 편도 1회 
            
            long maxW = cnt * w[i]; // 최대한 트럭에 싣고 옮길때 양
            long maxGold = Math.min(maxW, g[i]);  // 보유 금 넘지 않게
            long maxSilver = Math.min(maxW, s[i]); // 보유 은 넘지 않게
            
            long moveW = Math.min(g[i] + s[i], maxW);
            
            totalW += moveW;
            goldW += maxGold;
            silverW += maxSilver;
        }
        
        return totalW >= a+b && goldW >= a && silverW >= b;
    }
}