import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : number.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() < c) {
                deque.pollLast();
                k--;
            }
            deque.addLast(c);
        }
        
        while (k > 0) {
            deque.pollLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : deque) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}