import java.util.*;

class Solution {
    boolean[] visited;
    Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        dfs(numbers, "");
        
        int ans = 0;
        for (int n : numberSet) {
            if (isPrime(n)) {
                ans++;
            }
        }
        
        return ans;
    }
    
    private void dfs(String numbers, String curr) {
        if (!curr.isEmpty()) {
            numberSet.add(Integer.valueOf(curr));
        }
        
        for (int i=0; i<numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }
            
            if (curr.isEmpty() && numbers.charAt(i) == '0') {
                continue;
            }
            
            visited[i] = true;
            dfs(numbers, curr + numbers.charAt(i));
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i=2; (long) i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}