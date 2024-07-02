import java.util.*;

class Solution {
    static int N, goal;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] linked = new List[n + 1];
        N = n; goal = destination;
        for (int i = 1; i <= n; i++) {
            linked[i] = new ArrayList<>();
        }
        
        for (int[] r : roads) {
            linked[r[0]].add(r[1]);
            linked[r[1]].add(r[0]);
        }
        
        int[] minlen = new int[n + 1];
        Arrays.fill(minlen, -1);
        minlen[goal] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(goal);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : linked[current]) {
                if (minlen[i] == -1) {
                    minlen[i] = minlen[current] + 1;
                    queue.offer(i);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = minlen[sources[i]];
        }
        
        return answer;
    }
}