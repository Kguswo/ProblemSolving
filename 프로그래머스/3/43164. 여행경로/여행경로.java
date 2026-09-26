import java.util.*;

class Solution {
    String[][] tickets;
    boolean[] used;
    List<String> path = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.used = new boolean[tickets.length];    
    
        Arrays.sort(tickets, (a,b) -> a[1].compareTo(b[1]));
        
        path.add("ICN");
        dfs("ICN");
        return path.toArray(new String[0]);
    }
    
    private boolean dfs(String city) {
        if (path.size() == tickets.length + 1) return true;
        
        for (int i=0; i<tickets.length; i++) {
            if(used[i] || !tickets[i][0].equals(city)) continue;
            
            used[i] = true;
            path.add(tickets[i][1]);
            
            if(dfs(tickets[i][1])) return true;
            
            used[i] = false;
            path.remove(path.size() - 1);
        }
        
        return false;
    }
}