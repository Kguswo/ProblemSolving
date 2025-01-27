import java.util.*;

class Solution {
    class Robot{
        int r, c;
        boolean isEnd;
        public Robot(int r, int c, boolean isEnd){
            this.r = r;
            this.c = c;
            this.isEnd = isEnd;
        }
    }
    static int hitCnt=0;
    static int[] routeIdx;
    static Robot[] robot;
    static Map<Integer, List<Integer>> robotList; // r*100 + c, 로봇번호
    public int solution(int[][] points, int[][] routes) {
        robot = new Robot[routes.length];
        routeIdx = new int[routes.length]; // 다음 목적지 가리키는 Idx, 0 ~ routes[0].length-1 임
        
        // 시작점 
        for(int i=0; i<routes.length; i++){
            robot[i] = new Robot(points[routes[i][0]-1][0], points[routes[i][0]-1][1], false);
        }
        Arrays.fill(routeIdx, 1);
        
        
        //시작점도 같이 시작하면 충돌카운트 해줘야함
        robotList = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            makeRobotList(i);
        }
        hitCount();
        
        while(true){
            robotList = new HashMap<>();
            
            for(int i=0; i<routes.length; i++){
                if(robot[i].isEnd) continue;
                
                int currPointIdx = routes[i][routeIdx[i]-1] - 1;
                int[] currPoint = points[currPointIdx];
                int nextPointIdx = routes[i][routeIdx[i]] - 1;
                int[] nextPoint = points[nextPointIdx];
                
                move(currPoint, nextPoint, robot[i]);
                
                // 이동칸을 robotList에 기록
                makeRobotList(i);
                
                // 다음포인트 도착체크
                checkNextPointArrival(i, nextPoint, routes);
            }
            // 충돌카운트
            hitCount();
            
            boolean flag = true;
            for(Robot r : robot){
                if(!r.isEnd){
                    flag = false;
                    break;
                }
            }
            if(flag) break;
        }
        return hitCnt;
    }
    
    void move(int[] start, int[] next, Robot robot){
        if(robot.r != next[0]) robot.r += (robot.r > next[0]) ? -1 : 1;
        else if(robot.r == next[0] && robot.c != next[1]) robot.c += (robot.c > next[1]) ? -1 : 1;
    }
    
    void makeRobotList(int i){
        int pos = robot[i].r * 100 + robot[i].c;
        if(!robotList.containsKey(pos)) robotList.put(pos, new ArrayList<>());
        robotList.get(pos).add(i);
    }
    
    void checkNextPointArrival(int i, int[] nextPoint ,int[][] routes){
        if(robot[i].r == nextPoint[0] && robot[i].c == nextPoint[1]){
            routeIdx[i]++;
            if(routeIdx[i] >= routes[i].length) robot[i].isEnd = true;
        }
    }
    
    void hitCount(){
        for(List<Integer> rList : robotList.values()){
            if(rList.size() >= 2) hitCnt++;
        }
    }
}