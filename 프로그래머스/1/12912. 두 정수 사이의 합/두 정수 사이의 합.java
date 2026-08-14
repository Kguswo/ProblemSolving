public class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if (a==b) return a;
        
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }
        long cnt = (long) (b+1-a);
        answer = (a+b) * cnt / 2L;
        return answer;
    }
}