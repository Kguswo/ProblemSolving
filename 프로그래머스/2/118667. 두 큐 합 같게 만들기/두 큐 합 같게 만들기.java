import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i =0;i<arr1.length;i++){
            sum1+=arr1[i];
            sum2+=arr2[i];
            queue1.add(arr1[i]);
            queue2.add(arr2[i]);
        }
        
        if ((sum1 + sum2)%2 ==1 ) return -1;

        while (answer <= (arr1.length + arr2.length)*2 && !queue1.isEmpty() && !queue1.isEmpty()) {
            if (sum1 == sum2) return answer;

            if (sum1 > sum2) {
                queue2.add(queue1.peek());
                sum1 -= queue1.peek();
                sum2 += queue1.poll();
            } else {
                queue1.add(queue2.peek());
                sum2 -= queue2.peek();
                sum1 += queue2.poll();
            }
            answer++;
        }
        return -1;
    }
}