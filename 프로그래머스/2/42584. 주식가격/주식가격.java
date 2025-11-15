import java.util.*;

class Node {
    int idx, price;
    public Node(int idx, int price) {
        this.idx = idx;
        this.price = price;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, prices[0]));
        
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && stack.peek().price > prices[i]){
                Node n1 = stack.pop();
                res[n1.idx] = i - n1.idx;
            }
            stack.push(new Node(i, prices[i]));
        }
        
        while(!stack.isEmpty()){
            Node n2 = stack.pop();
            res[n2.idx] = (prices.length - 1) - n2.idx;
        }
        // System.out.println(Arrays.toString(res));
        return res;
    }
}