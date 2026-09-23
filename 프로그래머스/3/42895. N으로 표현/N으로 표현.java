import java.util.*;

class Solution {
    private static final int MAX_USE = 8;
    
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i=0; i<=MAX_USE; i++) {
            dp.add(new HashSet<>());
        }
        
        // k=1 ~ 8 돌면서 k장 붙인 수를 dp.get(k) 에 넣기
        int repeat = 0;
        for (int k=1; k<=MAX_USE; k++) {
            Set<Integer> curr = dp.get(k);
            
            // k 장 붙인 수
            repeat = repeat * 10 + N;
            curr.add(repeat);
            
            // a 장 목록 중 선택 + b장 목록 중 선택
            for (int a=1; a<k; a++) {
                int b = k-a;
                for (int x : dp.get(a)) {
                    for (int y : dp.get(b)) {
                        curr.add(x+y);
                        curr.add(x-y);
                        curr.add(x*y);
                        if (y != 0) curr.add(x/y);
                    }
                }
            }
            
            if (curr.contains(number)) return k;
        }
        
        return -1;
    }
}