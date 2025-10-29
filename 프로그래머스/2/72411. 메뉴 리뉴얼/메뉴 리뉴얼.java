import java.util.*;

class Solution {
    private static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> res = new ArrayList<>();
        
        for (int c : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                int len = order.length();
                
                if(len < c) continue;
                
                char[] chArr = order.toCharArray();
                boolean[] visited = new boolean[len];
                comb(chArr, visited, len, 0, 0, c);
            }
            
            // 내림차순
            List<String> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys, (o1, o2) -> {
               return Integer.compare(map.get(o2), map.get(o1)); 
            });
            
            if(map.isEmpty()) continue;
            
            int max = map.get(keys.get(0));
            if(max == 1) continue;
            
            for (String key : keys) {
                if (map.get(key) < max) {
                    break;
                }
                res.add(key);
            }
        }
        Collections.sort(res);
        String[] ans = new String[res.size()];
        return res.toArray(ans);
    }
    
    private void comb(char[] chArr, boolean[] visited, int len, int depth, int cnt, int target) {
        if(cnt == target) {
            updateMap(chArr, visited, len);
            return;
        }
        
        for(int i=depth; i<len; i++) {
            visited[i] = true;
            comb(chArr, visited, len, i+1, cnt+1, target);
            visited[i] = false;
        }
    }
    
    private void updateMap(char[] chArr, boolean[] visited, int len) {
        String str = sort_String(get_String(chArr, visited, len));
        map.merge(str, 1, Integer::sum);
    }
    
    private String get_String(char[] chArr, boolean[] visited, int len) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            if(visited[i]) sb.append(chArr[i]);
        }
        return sb.toString();
    }
    
    private String sort_String(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}