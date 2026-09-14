import java.util.*;

class Solution {
    class Job implements Comparable<Job> {
        int no;
        int req;
        int taken;
        public Job(int no, int req, int taken) {
            this.no = no;
            this.req = req;
            this.taken = taken;
        }
        
        public int compareTo(Job o) {
            if (this.taken != o.taken) {
                return this.taken - o.taken;
            }
            if (this.req != o.req) {
                return this.req - o.req;
            }
            return this.no - o.no;            
        }
    }
    
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int currTime = 0;
        int ans = 0;
        int idx = 0; // tmp에서 다음에 pq로 넣을 인덱스위치
        int jobCnt = 0; // 진행한 작업수
        int totalTurnaround = 0;
        
        Job[] tmp = new Job[jobs.length];
        for (int i=0; i<jobs.length; i++) {
            tmp[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(tmp, (a, b) -> a.req - b.req);
        
        while(jobCnt < tmp.length) {
            while (idx < tmp.length && tmp[idx].req <= currTime) {
                pq.offer(tmp[idx]);
                idx++;
            }
            
            if (pq.isEmpty()) {
                currTime = tmp[idx].req;
                continue;
            }
            
            Job job = pq.poll();
            currTime += job.taken;
            totalTurnaround += (currTime - job.req);
            jobCnt++;
        }
        
        return (totalTurnaround / jobCnt) ;
    }
}