import java.util.*;

public class Process{
    int pos, priority;
    public Process(int pos, int priority){
        this.pos = pos;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int max = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int p : priorities) {
            pq.add(p);    
        }
        
        Queue<Process> p_queue = new ArrayDeque<>();
        
        for(int i=0; i<priorities.length; i++) {
            p_queue.add(new Process(i, priorities[i]));
        }
        
        int targetPriority = pq.poll();
        boolean flag = false;
        int cnt = 0;
        
        while(!p_queue.isEmpty() && !flag) {
            Process currP = p_queue.poll();
            if(currP.priority == targetPriority) {
                cnt++;
                if(!pq.isEmpty()) targetPriority = pq.poll();
                
                if(currP.pos == location) {
                    flag = true;
                    break;
                }
            }
            else{
                p_queue.offer(currP);
            }
        }
        return cnt;
    }
}