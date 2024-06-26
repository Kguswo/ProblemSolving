class Solution {
    static long maxtime;
    public long solution(int n, int[] times) {
        long answer = 0;
        maxtime = (long) 1000000000 * 1000000000; // 이거 계속 틀려서 찾아보니 long을 붙여줘야 통과된다

        long left = 1;
        long right = maxtime;
        long mid = 0;
        
        while(left<=right){
            mid = (left + right)/2;
            long idx = addNum(mid, times);
            if(idx >= n){
                answer = mid;
                right = mid -1;
            }
            else{
                left = mid +1;
            }
        }
        return answer;
    }
    private static long addNum(long mid, int times[]){ // 합 구하기 -> n넘어가지 않는 최대구해야함
        long idx =0;
        for(int i=0; i<times.length; i++){
            idx += (mid/times[i]);
        }
        return idx;
    }
}