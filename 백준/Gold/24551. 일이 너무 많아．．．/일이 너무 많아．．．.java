/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static long[] arr = {11L, 111L, 11111L, 1111111L, 11111111111L, 1111111111111L, 11111111111111111L};
    static long N;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_24551_일이너무많아/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Long.parseLong(br.readLine());

        long res = 0;

        // combination, 0은 아무것도 안 고르는거니까 1부터
        for(int bit=1; bit<(1<<7); bit++){
//            long target = 1; // 11...111
            BigInteger target = BigInteger.ONE;
            int cnt = Integer.bitCount(bit); // 홀짝구분, 2*3, 2*5, 3*5 는 짝수개니까 빼주고, 2, 3, 5, 2*3*5는 홀수개니까 더해주고

            boolean flag = false;
            // 조합하고 개수세기 -> 11..111 생성하고 몇개의 소수 사용했는지 cnt에저장
            for(int i=0; i<7; i++){
                if((bit & (1<<i)) != 0){
//                    target = lcm(target, arr[i]);
                    target = lcm(target, BigInteger.valueOf(arr[i]));
//                    if(target > N) {
                    if(target.compareTo(BigInteger.valueOf(N)) > 0){
                        flag = true;
                        break;
                    }
                }
            }

            if(flag) continue;

//            if(cnt % 2 != 0) res += N / target;
//            else res -= N / target;
            if(cnt % 2 != 0) res += N / target.longValue();
            else res -= N / target.longValue();
        }

        System.out.println(res);

        bw.flush();
        bw.close();
        br.close();
    }

    static long gcd(long a, long b){
        while(b!=0){
            long tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }

//    static long lcm(long a, long b){
//        return a / gcd(a,b) * b;
//    }

    static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }
}