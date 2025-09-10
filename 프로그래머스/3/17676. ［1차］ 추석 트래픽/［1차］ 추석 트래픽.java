import java.util.*;

class Solution {
    static long[][] logs;
    public int solution(String[] lines) {
        int res = 0;
        logs = new long[lines.length][2];
        
        for(int i=0; i<lines.length; i++){
            // "2016-09-15 20:59:57.421 0.351s",
            String[] split = lines[i].split(" ");
            String[] time = split[1].split(":"); // 20, 59, 57.421
            String[] sec = time[2].split("\\."); // 57 421(소수점)
            String gap = split[2]; // 0.351s
            long endTime = getEndTime(time, sec);
            long startTime = getStartTime(endTime, gap);
            
            // System.out.println(startTime);
            // System.out.println(endTime);
            
            logs[i][0] = startTime;
            logs[i][1] = endTime;
        }
        
        List<Long> points = new ArrayList<>();
        for(int i=0; i<logs.length; i++){
            points.add(logs[i][0]);
            points.add(logs[i][1]);
        }
        
        for(long p : points){
            int cnt = 0;
            
            // |1초구간| 사이에 start나 end가 있어야함
            // logs[i][0]..1 -- |t -- logs[i][1]..1 ----- logs[i][0]..2 --- t+999| --- logs[i][1]..2
            for(int i=0; i<logs.length; i++){
                if(logs[i][0] <= p+999 && logs[i][1] >= p) cnt++;
            }
            
            res = Math.max(res, cnt);
        }
        
        
        return res;
    }
    
    private long getEndTime(String[] time, String[] sec){
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int s = Integer.parseInt(sec[0]);
        int ms = Integer.parseInt(sec[1]);
        
        return h * 3600 * 1000L + m * 60 * 1000L + s * 1000L + ms;
    }
    
    private long getStartTime(long endTime, String gap){
        String s = gap.substring(0, gap.length()-1); // s떼기
        // System.out.println(s);
        // long gapMs = (long) Double.parseDouble(s); // 소수점이 다 날아감 이렇게 하면 안됨
        double gapMs = Double.parseDouble(s);
        System.out.println("gapMS : " + gapMs);
        
        long gapSec = (long) (gapMs * 1000);
        System.out.println("gapSec : " + gapSec);
        
        return endTime - gapSec + 1;
    }
}