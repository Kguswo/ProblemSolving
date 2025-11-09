import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        int size = bridge_length;
        while(size-->0) {
            queue.offer(0);
        }
        
        int sum = 0;
        int idx = 0;
        while(queue.size() <= bridge_length){
            time++;
            sum -= queue.poll();
            if(sum + truck_weights[idx] <= weight) {
                sum += truck_weights[idx];
                queue.offer(truck_weights[idx]);
                
                if(idx == truck_weights.length-1) {
                    time += bridge_length;
                    break;
                }
                else idx++;
            }
            else queue.offer(0);
        }
        return time;
    }
}