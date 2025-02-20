import java.util.*;

class Solution {
    class Gap implements Comparable<Gap>{
        int start, end;
        public Gap(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Gap o){
            return this.end - o.end;
        }
    }
    static Gap[] gaps;
    public int solution(int[][] targets) {
        int res = 1;
        gaps = new Gap[targets.length];
        for(int i=0; i<targets.length; i++){
            gaps[i] = new Gap(targets[i][0], targets[i][1]);
        }
        
        Arrays.sort(gaps);
        
        // int s = gaps[0].start;
        int e = gaps[0].end; 
        
        for(int i=1; i<gaps.length; i++){
            int currS = gaps[i].start;
            int currE = gaps[i].end;
            
            if(e > currS) continue;
            else{
                res++;
                e = currE;
            }
        }
        
        return res;
    }
}