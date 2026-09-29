import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(1);
        visited[1] = true;
        
        int ans = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            ans = size;
            for (int i=0; i<size; i++) {
                int curr = queue.poll();
                for (int next : graph[curr]) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        
        return ans;
    }
}