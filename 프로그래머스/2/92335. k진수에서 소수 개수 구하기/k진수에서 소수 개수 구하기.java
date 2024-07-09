import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        if(n==0) return 0;
        while(n>0){
            sb.append(n%k);
            n /= k;
        }
        String newN = sb.reverse().toString(); // k진법으로 만든 수
        String[] arr = newN.split("0");
        for(String s : arr){
            if(!s.isEmpty() && isPrime(s)) answer++ ;
        }
        return answer;
    }
    private static boolean isPrime(String s){
        if(s.isEmpty()) return false;
        long n = Long.parseLong(s);
        if(n<=1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}