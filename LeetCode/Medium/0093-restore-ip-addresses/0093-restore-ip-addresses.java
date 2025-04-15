import java.util.*;

class Solution {
    static String str;
    static List<String> res;
    static StringBuilder sb;
    public List<String> restoreIpAddresses(String s) {
        str = s;
        res = new ArrayList<>();
        sb = new StringBuilder();

        int len = s.length();
        if(len <= 3 || len >= 13) return res;

        dfs(0, 0); // 0개, 0위치 -> 4개, 끝위치 까지 진행
        return res;
    }

    void dfs(int depth, int startIdx){
        if(depth == 4 && startIdx == str.length()){
            res.add(sb.toString());
            return;
        }

        if(depth > 4 || startIdx >= str.length()) return;

        for(int i=1; i<=3 && startIdx+i <= str.length(); i++){
            String part = str.substring(startIdx, startIdx + i);

            int prev_sbLen = sb.length();
            if(isValid(part)){
                if(prev_sbLen>0) sb.append(".");
                sb.append(part);
                dfs(depth+1, startIdx+i);
                sb.setLength(prev_sbLen);
            }
        }
    }

    boolean isValid(String s){
        int s_len = s.length();
        int num = Integer.parseInt(s);
        if(s_len == 1){
            return num >= 0 && num <= 9;
        }
        else if(s_len == 2){
            return num >= 10 && num <= 99;
        }
        else if(s_len == 3){
            return num >= 100 && num <= 255;
        }
        return false;
    }
}