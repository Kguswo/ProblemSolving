import java.util.*;

class Solution {
    static int networknum, computernum;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        networknum = 0;
        computernum = n;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(computers, i);
                networknum++;
            }
        }
        return networknum;
    }
    private static void dfs(int[][] computers, int from){        
        for(int i=0; i<computernum; i++){
            if(!visited[i] && computers[from][i]==1){
                visited[from] = true;
                dfs(computers, i);
            }
        }
    }
}