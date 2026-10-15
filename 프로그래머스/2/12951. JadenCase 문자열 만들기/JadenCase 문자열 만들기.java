class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ", -1);
        for (int i=0; i<split.length; i++) {
            if (!split[i].isEmpty()) {
                char curr = split[i].charAt(0);
                
                String rest = split[i].length() > 1 ? split[i].substring(1).toLowerCase() : "";
                split[i] = Character.toUpperCase(curr) + rest;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
            
            if (i < split.length - 1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}