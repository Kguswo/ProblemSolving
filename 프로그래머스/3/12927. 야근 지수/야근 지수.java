import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        while(n-->0 && !pq.isEmpty()){
            int tmp = pq.poll();
            if(tmp>0) pq.offer(--tmp);
        }
        
        long res=0;
        while(!pq.isEmpty()){
            res += (long) Math.pow(pq.poll(), 2);
        }
        return res;
    }
}