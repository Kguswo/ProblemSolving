class Solution {
    public int solution(int n, int[] cores) {
        if(n <= cores.length) return n;
        
        n -= cores.length;
        
        int left = 1, right =  250000000;
        
        int res = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            
            long cnt = 0;
            for(int i=0; i<cores.length; i++){
                cnt += (long) mid / cores[i];
            }
            
            if(cnt >= n){
                res = mid;
                right = mid-1;
            }
            else{
                left = mid + 1;
            }
        }
        
        // 일단 res시간까진 작업이 완료된다는걸 찾음
        
        long work = 0;
        for(int i=0; i<cores.length; i++){
            work += (long) (res-1) / cores[i];
        }
        
        int ans = cores.length;
        
        for(int i=0; i<cores.length; i++){
            if(res % cores[i] == 0) {
                work++;
                if(work == n) {
                    ans = i+1;
                    break;
                }
            }
        }
        return ans;
    }
}