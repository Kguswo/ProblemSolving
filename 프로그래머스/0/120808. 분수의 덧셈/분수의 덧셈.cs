using System;

public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        answer[0] = numer1 * denom2 + numer2 * denom1;
        answer[1] = denom1 * denom2;
        int gcd = GCD(answer[0], answer[1]);
        
        for (int i=0; i<answer.Length; i++){
            answer[i] /= gcd;
        }
        return answer;
    }
    
    private int GCD(int n, int m) {
        while (n > 0) {
            int tmp = n;
            n = m % n;
            m = tmp;
        }
        return m;
    }
}