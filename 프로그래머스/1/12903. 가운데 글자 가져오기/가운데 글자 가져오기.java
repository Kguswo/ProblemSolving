class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        if(isOddNum(s)){
            sb.append(s.charAt(s.length() / 2));
        }
        else{
            for(int i=s.length() / 2 - 1; i<=s.length() / 2; i++){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
    private boolean isOddNum(String s){
        return s.length() % 2 != 0;
    }
}