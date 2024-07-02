// 거꾸로 통과(거리 저장)
import java.util.*;

class Solution {
    static List<Integer>[] linked;
    static int[] minlen;
    static int N, goal;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        linked = new ArrayList[n + 1];
        N = n;
        goal = destination;
        
        for (int i = 1; i <= n; i++) {
            linked[i] = new ArrayList<>();
        }
        
        for (int[] r : roads) {
            linked[r[0]].add(r[1]);
            linked[r[1]].add(r[0]);
        }

        minlen = new int[N + 1];
        bfs(goal);
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = minlen[sources[i]];
        }
        return answer;
    }
    
    private static void bfs(int end) {
        for(int i=1; i<=N; i++){
            if(i==end) minlen[i] = 0;
            else minlen[i] = -1;
        }
        // minlen[end] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            for (int a : linked[cur]) {
                if (minlen[a] == -1) {
                    minlen[a] = minlen[cur] + 1;
                    queue.add(a);
                }
            }
        }
    }
}