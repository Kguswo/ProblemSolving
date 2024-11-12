import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    List<String> divideInMinus = new ArrayList<>();
    public int solution(String arr[]) {
        for(String s : arr){
            if(s.equals("-")){
                if(sb.length()>0){
                    divideInMinus.add(sb.toString());
                    sb.setLength(0); // 새로운 객체 생성보다 부담 적고 delete연산은 이것보다 더 많은 연산 수행하므로 이게 제일 효율적
                }
            }
            else{
                sb.append(s);
            }
        }
        if(sb.length() > 0) divideInMinus.add(sb.toString());
    
        // 이제 뒤에서부터 덧셈으로 묶인 부분의 최솟값과 최댓값을 찾는다. 제일 첫번째 항목은 -가 불가능하므로 1번인덱스부터 끝인덱스를 역순으로.
        
        // 맨 앞 양수 항
        String[] firstNums = divideInMinus.get(0).split("\\+");
        int firstSum = 0;
        for(String num : firstNums){
            firstSum += Integer.parseInt(num);
        }
        
        int fromBackToSecond_Max = 0;
        int fromBackToSecond_Min = 0;
        
        for(int i=divideInMinus.size()-1; i>=1; i--){
            int currMax = calMax(divideInMinus.get(i));
            int currMin = calMin(divideInMinus.get(i));
            
            fromBackToSecond_Max = Math.max(currMax + fromBackToSecond_Max, currMin - fromBackToSecond_Min);
            fromBackToSecond_Min = Math.min(currMin + fromBackToSecond_Min, currMin - fromBackToSecond_Min);
        }
        
        int res = firstSum + fromBackToSecond_Max;
        return res;
    }
    private int calMax(String str){
        String[] nums = str.split("\\+"); // regex
        // String[] nums = str.split(Pattern.quote("+"));
        int max = (-1) * Integer.parseInt(nums[0]);
        for(int i=1; i<nums.length; i++){
            max += Integer.parseInt(nums[i]);
        }
        return max;
    }
    private int calMin(String str){
        String[] nums = str.split("\\+"); // regex
        // String[] nums = str.split(Pattern.quote("+"));
        int min = 0;
        for(String num : nums){
            min += Integer.parseInt(num);
        }
        return (-1) * min;
    }
}