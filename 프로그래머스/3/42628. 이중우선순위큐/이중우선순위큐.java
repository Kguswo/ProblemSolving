import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> validCount = new HashMap<>();
        int size = 0;
        
        for (String op : operations) {
            String[] split = op.split(" ");
            String cmd = split[0];
            int num = Integer.parseInt(split[1]);
            
            if (cmd.equals("I")) {
                maxHeap.offer(num);
                minHeap.offer(num);
                validCount.merge(num, 1, Integer::sum);
                size++;
            }
            else if (cmd.equals("D")) {
                if (size==0) continue;
                
                // 최댓값 삭제
                if (num == 1) {
                    while (validCount.get(maxHeap.peek())==0) {
                        maxHeap.poll();
                    }
                    int target = maxHeap.poll();
                    validCount.merge(target, -1, Integer::sum);
                }
                // 최솟값 삭제
                else {
                    while(validCount.get(minHeap.peek())==0) {
                        minHeap.poll();
                    }
                    int target = minHeap.poll();
                    validCount.merge(target, -1, Integer::sum);
                }
                size--;
            }
        }
        
        if (size == 0) {
            return new int[] {0,0};
        }
        
        while (validCount.get(maxHeap.peek()) == 0) {
            maxHeap.poll();
        }
        while (validCount.get(minHeap.peek()) == 0) {
            minHeap.poll();
        }
       
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}