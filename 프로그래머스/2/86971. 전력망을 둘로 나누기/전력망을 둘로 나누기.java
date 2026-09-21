import java.util.*;

class Solution {
    List<Integer>[] graph;
    int[] subtreeSize;
    int n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        graph = new List[n+1];
        for (int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] w : wires) {
            graph[w[0]].add(w[1]);
            graph[w[1]].add(w[0]);
        }
        
        subtreeSize = new int[n+1];
        dfs(1, 0);
        
        int answer = Integer.MAX_VALUE;
        for (int v=1; v<=n; v++) {
            // 1번 제외 v와 v의 부모 잇는 간선 끊기
            if (v==1) continue;
            int one = subtreeSize[v];
            int other = n - one;
            answer = Math.min(answer, Math.abs(one - other));
        }
        
        return answer;
    }
    
    private void dfs(int node, int parent) {
        subtreeSize[node] = 1;
        for (int next : graph[node]) {
            if (next == parent) continue;
            dfs(next, node);
            subtreeSize[node] += subtreeSize[next];
        }
    }
}