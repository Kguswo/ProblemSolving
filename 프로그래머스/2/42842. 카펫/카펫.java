import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int add;
    static List<int[]> list;
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        list = new ArrayList<>();
        add = brown + yellow;
        getXYsets();
    
        list = list.stream() // 리스트를 stream으로 변환
               .filter(xy -> brown == 2 *xy[0] + 2*xy[1] -4) // 조건 만족하는것만 남기고
               .collect(Collectors.toList()); // 리스트로 변환
        
        answer = list.get(0);
        
        return answer;
    }
    
    private static void getXYsets(){
        for(int x=1; x<=add; x++){
            if(add % x == 0){
                int y = add / x;
                if(x >= y) list.add(new int[] {x, y});
            }
        }    
    }
    
    
}