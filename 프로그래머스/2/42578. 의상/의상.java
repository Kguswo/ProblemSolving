import java.util.*;

class Solution {
    private static List<String> list;
    private Map<String, Integer> map;
    public int solution(String[][] clothes) {
        int type = 0;
        
        map = new HashMap<>();
        list = new ArrayList<>();
        
        for(String[] cloth : clothes) {
            if(!map.containsKey(cloth[1])) {
                type++;
                list.add(cloth[1]);
                map.put(cloth[1], 0);
            }
            map.put(cloth[1], map.get(cloth[1]) + 1);
        }
        
        int res = 1;
        for(int i=0; i<type; i++) {
            res *= (map.get(list.get(i)) + 1);
        }
        
        
        return res - 1;
    }
    
//     private int combination(int start, int cnt, int target, int multiply) {
//         if(cnt == target) {
//             return multiply;
//         }
        
//         int sum = 0;
//         for(int i=start; i<list.size(); i++) {
//             sum += combination(i+1, cnt+1, target, multiply * map.get(list.get(i)));
//         }
//         return sum;
//     }
}
/*
의상종류별 - 의상개수 가 있을텐데
1개 ~ 의상종류개수 까지 선택가능
1개 ... 의상개수
2개 ... 의상종류조합 -> 각 조합마다 콤비네이션
*/