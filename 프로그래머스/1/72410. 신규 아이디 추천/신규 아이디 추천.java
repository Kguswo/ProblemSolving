class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        
        //1
        String str = new_id.toLowerCase();
        
        //2
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        str = sb.toString(); 
        
        //3
        sb.setLength(0);
        for (int i=0; i<str.length(); i++) {
            if (i > 0 && str.charAt(i) == '.' && str.charAt(i-1) == '.') {
                continue;
            }
            sb.append(str.charAt(i));
        }
        str = sb.toString();
        
        //4
        sb.setLength(0);
        for (int i=0; i<str.length(); i++) {
            if ((i == 0 || i == str.length()-1) && str.charAt(i) == '.') {
                continue;
            }
            sb.append(str.charAt(i));
        }
        str = sb.toString();
        
        //5
        sb.setLength(0);
        if (str.length() == 0) {
            str = "a";
        }
        
        //6
        sb.setLength(0);
        if (str.length() >= 16) {
            for (int i=0; i<15; i++) {
                sb.append(str.charAt(i));
            }
            
            str = sb.toString();
            
            if (str.charAt(str.length()-1) == '.') {
                str = str.substring(0, 14);
            }
        }
        
        //7
        sb.setLength(0);
        if (str.length() <= 2) {
            if (str.length() == 0) {
            }
            else if (str.length() == 1) {
                for (int i=0; i<3; i++) {
                    sb.append(str.charAt(0));
                }
            }
            else if (str.length() == 2){
                sb.append(str.charAt(0));
                for (int i=1; i<3; i++) {
                    sb.append(str.charAt(1));
                }
            }
            str = sb.toString();
        }
        
        // System.out.println(str);
        
        return str;
    }
}