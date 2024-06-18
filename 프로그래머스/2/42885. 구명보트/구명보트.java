import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(people[0]);
        
        for(int i=1; i<people.length; i++){
            boolean flag = false;
            // int size = list.size();
            // for(int a : list){
            //     if(people[i] + a <= limit) a += people[i];
            //     else list.add(people[i]);
            //     break;
            // }
            for(int j=0; j<list.size(); j++){
                if(people[i] + list.get(j) <= limit){
                    list.set(j, people[i] + list.get(j));
                    flag = true;
                    break;
                }
            }
            if(!flag) list.add(people[i]);
        }
        return list.size();
    }
}