import java.util.*;

class Solution {
    static List<Integer> list;
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        list = new ArrayList<>();
        for (int a : people) list.add(a); 
        while (!list.isEmpty()) {
            if (list.size() >= 2 && list.get(0) + list.get(list.size() - 1) <= limit) { // 젤 가벼운애 한명 더 태울 수 있으면 같이태움
                list.remove(0);
                list.remove(list.size() - 1);
            } else list.remove(list.size() - 1); // 한명만 태울때
            answer++;
        }
        return answer;
    }
}
