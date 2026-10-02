import java.util.*;

class Solution {
    public int solution(String s) {
        int ans = s.length();
        
        for (int len=1; len<=s.length() / 2 + 1; len++) {
            // System.out.println("길이 : " + len);
            StringBuilder sb = new StringBuilder(); // 만들어볼 문자열
            String target = s.substring(0, len); // 조각
            int targetCnt = 1;
            
            // 각 조각 개수 세야함.
            for (int start=len; start<s.length(); start+=len) {
                // System.out.println("타겟 : " + target);
                int end = Math.min(s.length(), start+len); // substring 할 끝
                String curr = s.substring(start, end);
                // System.out.println("요번비교대상 : " + curr);
                if (curr.equals(target)) {
                    targetCnt++;
                }
                else {
                    if (targetCnt >= 2) {
                        sb.append(targetCnt);
                    }
                    sb.append(target);
                    // 다음을 위한 세팅
                    target = curr;
                    targetCnt = 1;
                }
            }
            
            if (targetCnt >= 2) {
                sb.append(targetCnt);
            } 
            sb.append(target);
            
            ans = Math.min(ans, sb.length());
            
            // System.out.println("결과물   " + sb.toString());
            // System.out.println("");
        }
        
        return ans;
    }
}