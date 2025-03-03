/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static String N, M;
    static int N_len, M_len;
    static final int MOD = 900528;
    static long res = 0;
    static Map<Character, Integer> charPos = new HashMap<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1394_암호/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = br.readLine();
        M = br.readLine();
        N_len = N.length();
        M_len = M.length();

        /*
        M_len-1까지 모든 경우의수는 다 더해야함. 길이 0이면 0
        나머지 M_len의 경우의수 추가
         */

        long power = N_len;
        for (int i = 1; i < M_len; i++) {
            res = (res + power) % MOD;
            power = (power * N_len) % MOD;
        }

        for (int i = 0; i < N_len; i++) {
            charPos.put(N.charAt(i), i);
        }

        long[] weights = new long[M_len];
        weights[M_len - 1] = 1;

        for(int i = M_len - 2; i >= 0; i--) {
            weights[i] = (weights[i + 1] * N_len) % MOD;
        }

        for (int i = 0; i < M_len; i++) {
            char curr = M.charAt(i);
            int currPos = charPos.get(curr);

            res = (res + (currPos * weights[i]) % MOD) % MOD;

        }

        // 마지막에 암호 자체도 카운트
        res = (res + 1) % MOD;

        System.out.println(res);

        bw.flush();
        bw.close();
        br.close();
    }

    private void getPerCnt(int len) {
        long tmp = 1;
        for(int i=0; i<len; i++) {
            tmp = (tmp * N_len) % MOD;
        }
        res = (res + tmp) % MOD;
    }
    
    // 모듈러 곱셈의 역원 계산 (페르마의 소정리)
    public static long modinverse(long a, long m) {
        return power(a, m - 2, m);
    }

    // 거듭제곱 계산 (분할 정복)
    public static long power(long base, long exp, long mod) {
        long num = 1;
        base = base % mod;

        while (exp > 0) {
            if (exp % 2 == 1) {
                num = (num * base) % mod;
            }
            exp = exp >> 1; // 나누기2
            base = (base * base) % mod;
        }

        return num;
    }

}