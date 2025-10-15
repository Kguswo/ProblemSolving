class Solution {
    private static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int res = 0;
        visited = new boolean[n]; // 0-based
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, n, computers);
                res++;
            }
        }
        return res;
    }
    
    private void dfs(int curr, int n, int[][] computers){
        visited[curr] = true;
        for(int i=0; i<n; i++){
            if(!visited[i] && computers[curr][i]==1) dfs(i, n, computers);
        }
    } 
}