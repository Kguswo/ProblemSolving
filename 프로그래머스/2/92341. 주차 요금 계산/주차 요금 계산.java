import java.util.*;
/*
  map으로 관리 
  Integer, ArrayList<Integer> 로 입출차관리 -> 길이 홀수면 23:59로채움
  Integer, Integer로 합 관리
*/
class Solution {
    static int cTime, cNumber;
    static String cActivity;
    static Map<Integer, Integer> timeSumMap = new TreeMap<>();
    static Map<Integer, ArrayList<Integer>> timeTableMap = new HashMap<>();
    static List<Integer> carNums;
    static int[] res;
    public int[] solution(int[] fees, String[] records) {
        for(String s : records){
            // s = s.subString(1, s.length()-1);
            String[] split = s.split(" ");
            
            String[] cTimeSplit = split[0].split(":");
            cTime = Integer.parseInt(cTimeSplit[0]) * 60 + Integer.parseInt(cTimeSplit[1]);
            cNumber = Integer.parseInt(split[1]);
            cActivity = split[2];
            
            if(cActivity.equals("IN")){
                timeTableMap.putIfAbsent(cNumber, new ArrayList<Integer>());
                timeTableMap.get(cNumber).add(cTime); //입차시간
            }
            else{
                ArrayList<Integer> timeList = timeTableMap.get(cNumber);
                
                int timeGap = cTime - timeList.get(timeList.size()-1); // 출차 - 마지막입차
                int sum = timeSumMap.getOrDefault(cNumber, 0) + timeGap;
                timeSumMap.put(cNumber, sum);
                timeList.add(cTime); // 출차시
            }
        }
        
        for(int num : timeTableMap.keySet()){
            ArrayList<Integer> timeList = timeTableMap.get(num);
            if(timeList.size() % 2 == 1){
                int timeGap = 23 * 60 + 59 - timeList.get(timeList.size()-1);
                int sum = timeSumMap.getOrDefault(num, 0) + timeGap;
                timeSumMap.put(num, sum);
            }
        }
        
        res = new int[timeSumMap.size()];
        int idx = 0;
        for(int num : timeSumMap.keySet()){
            int money = fees[1];
            if(timeSumMap.get(num) > fees[0]){
                money += (int) Math.ceil((double) (timeSumMap.get(num)-fees[0]) / fees[2]) * fees[3];
            }
            res[idx++] = money;
        }
        return res;
    }
}