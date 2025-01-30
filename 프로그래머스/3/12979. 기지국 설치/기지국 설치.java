class Solution {
    static int left, right, width, len, res;
    public int solution(int n, int[] stations, int w) {
        res = 0;
        width = 2*w+1;
            
        left = 1; right = stations[0] - w - 1;
        add5G();
        
        for(int i=1; i<stations.length; i++){
            left = stations[i-1]+w+1; right = stations[i]-w-1;
            add5G();
        }
        
        left = stations[stations.length-1]+w+1; right = n;
        add5G();
        
        return res;
    }
    
    private void add5G(){      
        if(left<=right) {
            len = right-left+1;
            res += len / width;
            res += (len % width) == 0 ? 0 : 1;
            return;
        }
        return;
    }
}