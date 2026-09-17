class Solution {
    int ans;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        ans = 0;
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return ans;    
    }
    
    private void dfs(int k, int[][] dungeons, int cnt) {
        ans = Math.max(ans, cnt);
        
        for (int i=0; i<dungeons.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if (k < dungeons[i][0]) {
                continue;
            }
            
            visited[i] = true;
            dfs(k - dungeons[i][1], dungeons, cnt+1);
            visited[i] = false;
        }
    }
}