import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        int num;
        int x, y;
        Node left, right;
        Node(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node o){
            if(this.y == o.y) return this.x - o.x;
            return o.y - this.y;
        }
        
    }
    List<Integer> preorder, postorder;
    public int[][] solution(int[][] nodeinfo) {
       
        int N = nodeinfo.length;
        List<Node> board = new ArrayList<>();
        for(int i=0; i<N; i++){
            board.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(board);
        
        Node root = board.get(0);
            
        for(int i=1; i<board.size(); i++){
            insert(root, board.get(i));
        }
        
        
        preorder = new ArrayList<>();
        postorder = new ArrayList<>();
        
        getPreOrder(root);
        getPostOrder(root);
        
        int[][] res = new int[2][N];
        
        for(int i=0; i<N; i++){
            res[0][i] = preorder.get(i);
            res[1][i] = postorder.get(i);
        }
        return res;
    }
    
    private void insert(Node parent, Node child){
        // 왼쪽자식
        if(child.x < parent.x){
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }
        // 오른쪽자식
        else{
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    private void getPreOrder(Node node){
        if(node == null) return;
        
        preorder.add(node.num);
        getPreOrder(node.left);
        getPreOrder(node.right);
    }
    
    private void getPostOrder(Node node){
        if(node == null) return;
        
        getPostOrder(node.left);
        getPostOrder(node.right);
        postorder.add(node.num);
    }
}