class Solution {
    static long d, p;
    static int idx;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        d=0; p=0;
        idx = deliveries.length-1;
        
        while (idx>=0){
            d+=deliveries[idx];
            p+=pickups[idx];
            
            // 배달이든 수거든 할 게 있으면
            if(d>0 || p>0){
                while (true){  // 둘 다 음수 될때까지(0이나 음수값 가지고 가야 추가로 더 담고다닐 수 있음)
                    if(d<=0 && p<=0) break;
                    d-=cap;
                    p-=cap;
                    answer+= 2*idx+2;
                }
                idx--;
            }
            else idx--;
        }
        return answer;
    }
}