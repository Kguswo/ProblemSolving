class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int left, right;
        left = 0;
        right = costs.length - 1;
        PriorityQueue<Integer> left_pq = new PriorityQueue<>();
        PriorityQueue<Integer> right_pq = new PriorityQueue<>();
         
        for(int i=0; i<candidates; i++){
            if(left <= right) left_pq.offer(costs[left++]);
        }
        for(int i=0; i<candidates; i++){
            if(left <= right) right_pq.offer(costs[right--]);
        }
        long res=0;

        while(k-->0){
            int a, b;
            if(left_pq.isEmpty()) {
                res += right_pq.poll();
                continue;
            }
            else if(right_pq.isEmpty()){
                res += left_pq.poll();
                continue;
            }

            a = left_pq.peek();
            b = right_pq.peek();
            if(a <= b) {
                left_pq.poll();
                if(left <= right) left_pq.offer(costs[left++]);
                res+= a;
            }    
            else if (b < a){
                right_pq.poll();
                if(left <= right) right_pq.offer(costs[right--]);
                res += b;
            }
        }

        return res;
    }
}