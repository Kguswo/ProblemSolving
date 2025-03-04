import java.util.*;

class Solution {
    static int[] p;
    static ArrayList<Integer>[] board;
    static Map<Integer, Integer> p_visited = new HashMap<>();
    public int[] solution(int[] nodes, int[][] edges) {
        /*
            트리 그룹으로 나누고 각 그룹마다 홀짝트리 or 역홀짝트리 여부 보기
            -> 홀짝이 1개면 g2++ , 역홀짝이 1개면 g1++
        */
        
        int g1=0, g2=0; // g1 : 홀짝트리 수, g2 : 역홀짝트리 수
        int s = 0;
        for(int n : nodes){
            if(s < n) s = n;
        }
        
        p = new int[s + 1];
        for(int i=0; i<nodes.length; i++){
            p[nodes[i]] = nodes[i];
        }
        
        board = new ArrayList[s+1];
        for(int i=1; i< s + 1; i++){
            board[i] = new ArrayList<>();
        }
        
        for(int[] e : edges){
            board[e[0]].add(e[1]);
            board[e[1]].add(e[0]);
        }
        
        for(int[] e : edges){
            union(find(e[0]), find(e[1]));
        }
        
        for(int i=0; i<nodes.length; i++){
            int node = find(nodes[i]);
            if(!p_visited.containsKey(node)){
                p_visited.put(node, 0);
                
                int[] tmp = bfs(node);
                if(tmp[0] == 1) g1++;
                if (tmp[1] == 1) g2++;
            }
        }
        
        int[] res = new int[]{g1, g2};
        return res;
    }
    
    private void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px <= py) p[py] = px;
        else p[px] = py;
        return;
    }
    
    private int find(int x){
        if(p[x] != x) return p[x] = find(p[x]);
        return x;
    }
    
    private int[] bfs(int node){
        System.out.println("시작 : " + node);
        int tmp_g1=0, tmp_g2=0; // 홀짝 and 역홀짝 개수세기
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        queue.offer(node);
        visited.add(node);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            int currSize = board[curr].size();
            
            if((curr + currSize) % 2 == 0) tmp_g1++;
            else tmp_g2++;
            
            for(int next : board[curr]){
                if(visited.add(next)){
                    queue.offer(next);
                }
            }
        }

        return new int[]{tmp_g1, tmp_g2};
    }
}