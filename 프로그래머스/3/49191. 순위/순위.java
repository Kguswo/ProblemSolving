//sol_1 bfs
import java.util.*;

class Solution {
    static int N;
    public int solution(int n, int[][] results) {
        List<Integer>[] win = new ArrayList[n+1];
        List<Integer>[] lose = new ArrayList[n+1];
        
        for (int i=0; i<=n; i++) {
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }
        
        for (int[] result : results) {
            win[result[0]].add(result[1]);
            lose[result[1]].add(result[0]);
        }
        N = n;
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (bfs(i, win) + bfs(i, lose) == n-1) ans++;
        }
        
        return ans;
    }
    
    private static int bfs(int start, List<Integer>[] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
        int cnt = 0;
        
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph[curr]) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }    
        }
        
        return cnt;
    }
}