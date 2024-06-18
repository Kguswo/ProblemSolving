import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        List<Integer> list = new ArrayList<>();
        
        for (int a : people) {
            list.add(a);
        }

        while (!list.isEmpty()) {
            int lastnum = list.get(list.size() - 1); // 맨 뒤에 있는 사람의 몸무게
            if (list.size() > 1 && list.get(0) + list.get(list.size() - 1) <= limit) { // 젤 가벼운애 한명 더 태울 수 있으면 같이태움
                list.remove(0);
                list.remove(list.size() - 1);
            } else list.remove(list.size() - 1); // 한명만 태울때
            answer++;
        }

        return answer;
    }
}
