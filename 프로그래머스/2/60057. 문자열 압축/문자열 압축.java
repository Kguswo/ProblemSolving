import java.util.*;
import java.lang.Math; // Math.min 사용하기위해

class Solution {
    static int sLength, minAnswer, idx, l; 
    public int solution(String s) {        
        sLength = s.length();
        if (sLength == 1) return 1;        
        minAnswer = Integer.MAX_VALUE;
        for (int i = 1; i <= sLength / 2; i++) {
            idx = 0;
            l = 0;
            while (idx + i <= sLength) {
                String unit = s.substring(idx, idx + i);
                int nextIdx = idx + i;
                int count = 1; // 같은 단어 몇개?

                while (nextIdx + i <= sLength && s.substring(nextIdx, nextIdx + i).equals(unit)) {
                    nextIdx += i;
                    count++;
                }

                if (count > 1) {
                    l += i + Integer.toString(count).length();
                } else {
                    l += i;
                }

                idx = nextIdx;
            }

            l += sLength - idx;
            minAnswer = Math.min(minAnswer, l);
        }

        return minAnswer;
    }
}