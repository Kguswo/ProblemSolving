import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                dq.push('(');
            }else{
                if(dq.isEmpty()) return false;
                else {
                    if(dq.peek() == '(') dq.poll();
                    else dq.push(')');
                }
            }
        }
        if(dq.isEmpty()) return true;
        else return false;
    }
}