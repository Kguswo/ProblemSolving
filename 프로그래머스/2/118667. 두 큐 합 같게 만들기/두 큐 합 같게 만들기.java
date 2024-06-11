import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int i : arr1) {
            queue1.offer(i);
            sum1 += i;
        }

        for (int i : arr2) {
            queue2.offer(i);
            sum2 += i;
        }

        int size1 = queue1.size();
        int size2 = queue2.size();

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (sum1 == sum2) return answer;

            if (sum1 > sum2) {
                size1--;
                int popped = queue1.poll();
                queue2.offer(popped);
                sum1 -= popped;
                sum2 += popped;
            } else {
                size2--;
                int popped = queue2.poll();
                queue1.offer(popped);
                sum2 -= popped;
                sum1 += popped;
            }

            if (size1 <= 0 && size2 <= 0) return -1;
            answer++;
        }

        return -1;

    }
}