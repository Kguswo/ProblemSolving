import java.util.*;

class Solution {
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static int mix;
    public int solution(int[] scoville, int K) {
        mix = 0;
        for (int a : scoville) queue.add(a);
        
        while (queue.size() >= 2) {
            if (queue.peek() >= K) return mix;

            int first = queue.poll();
            int second = queue.poll();
            int newfood = first + (second * 2);
            queue.add(newfood);
            mix++;
        }
        if (queue.peek() >= K) return mix;
        return -1;
    }
}
