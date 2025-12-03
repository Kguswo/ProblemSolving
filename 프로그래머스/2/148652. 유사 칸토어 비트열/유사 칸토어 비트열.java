class Solution {
    public int solution(int n, long l, long r) {
        
        int startDepth = n;
        long nl = l-1;
        long nr = r-1;
        
        // 공통 조상
        while(startDepth > 0 && nl != nr) {
            nl = l / 5L;
            nr = r / 5L;
            startDepth--;
        }
        
        int cnt = 0;
        for(long i=l-1; i<=r-1; i++) {
            if(findOne(i)) cnt++;
        }
        
        return cnt;
    }
    
    private boolean findOne(long i) {
        while(i>0) {
            if(i%5 == 2) return false;
            i /= 5L;
        }
        return true;
    }
}

/*

1  1
5  1101
25 110`11 11011 00000 11`011
0 구간 ~ 5k - 1 구간
5^n-1    l/5   r/5
5^n       l     r
*/
