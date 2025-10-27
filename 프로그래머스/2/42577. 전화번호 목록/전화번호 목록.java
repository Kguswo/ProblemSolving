import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        int n = phone_book.length;
        int minLen = phone_book[0].length();
        int maxLen = phone_book[n-1].length();
        
        Map<String, Boolean> map = new HashMap<>();
        
        for(String phone : phone_book) {
            map.putIfAbsent(phone, true);
            minLen = Math.min(minLen, phone.length());
            maxLen = Math.max(maxLen, phone.length());
        }
        
        for(int i=1; i<n; i++) {
            for(int j = minLen; j <= Math.min(maxLen, phone_book[i].length()); j++) {
                String curr = phone_book[i].substring(0, j);
                if(map.containsKey(curr) && j != phone_book[i].length()) return false; // 본인을 찾는건 제외
            }
        }
        
        return true;
        
    }
}