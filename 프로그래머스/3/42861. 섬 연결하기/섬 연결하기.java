import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);    
        
        int ans = 0;
        for (int[] cost : costs) {
            int n1 = cost[0];
            int n2 = cost[1];
            int price = cost[2];
            
            if (find(n1) != find(n2)) {
                union(n1, n2);
                ans += price;
            }
            else {
                continue;
            }
        }
        
        return ans;
    }
    
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[py] = px;
        }
    }
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}