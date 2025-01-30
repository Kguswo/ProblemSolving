class Solution {
    static int left, right, width;
    public int solution(int n, int[] stations, int w) {
        int res = 0;
        width = 2*w+1;
            
        left = 1;
        right = stations[0] - w - 1;
        res += getCnt();
        
        for(int i=1; i<stations.length; i++){
            left = stations[i-1]+w+1;
            right = stations[i]-w-1;
            res += getCnt();
        }
        
        left = stations[stations.length-1]+w+1;
        right = n;
        res += getCnt();
        
        return res;
    }
    
    private int getCnt(){
        if(left<=right) {
            return ((right-left+1) % width) == 0 ? ((right-left+1) / width) : ((right-left+1) / width) + 1;
        }
        else return 0;
    }
}