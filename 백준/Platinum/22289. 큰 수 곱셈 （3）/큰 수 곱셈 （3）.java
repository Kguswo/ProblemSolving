/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    public static class NTT {
        static final long MOD = 998244353;
        static final long PRIMITIVE_ROOT = 3;

        static long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }

        static void ntt(long[] a, boolean invert) {
            int n = a.length;

            // bit-reversal permutation
            for (int i = 1, j = 0; i < n; i++) {
                int bit = n >> 1;
                while (j >= bit) {
                    j -= bit;
                    bit >>= 1;
                }
                j += bit;
                if (i < j) {
                    long temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            // NTT computation
            for (int len = 2; len <= n; len <<= 1) {
                long wlen = pow(PRIMITIVE_ROOT, (MOD - 1) / len);
                if (invert) {
                    wlen = pow(wlen, MOD - 2);
                }

                for (int i = 0; i < n; i += len) {
                    long w = 1;
                    for (int j = 0; j < len/2; j++) {
                        long u = a[i + j];
                        long v = a[i + j + len/2] * w % MOD;

                        a[i + j] = (u + v) % MOD;
                        a[i + j + len/2] = (u - v + MOD) % MOD;

                        w = w * wlen % MOD;
                    }
                }
            }

            if (invert) {
                long inv_n = pow(n, MOD - 2);
                for (int i = 0; i < n; i++) {
                    a[i] = a[i] * inv_n % MOD;
                }
            }
        }

        static long[] multiply(long[] a, long[] b) {
            int n = 1;
            while (n < a.length + b.length) n <<= 1;

            long[] fa = Arrays.copyOf(a, n);
            long[] fb = Arrays.copyOf(b, n);

            ntt(fa, false);
            ntt(fb, false);

            for (int i = 0; i < n; i++) {
                fa[i] = fa[i] * fb[i] % MOD;
            }

            ntt(fa, true);
            return fa;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_15576_큰수곱셈2/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int lenA = A.length();
        int lenB = B.length();
        int maxLen = Math.max(lenA, lenB);

        int n = 1;
        while (n < lenA + lenB - 1) n <<= 1;

        long[] LL_A = new long[n];
        long[] LL_B = new long[n];

        for(int i=0; i<lenA; i++) {
            LL_A[i] = A.charAt(lenA-1-i) - '0';
        }

        for(int i=0; i<lenB; i++) {
            LL_B[i] = B.charAt(lenB-1-i) - '0';
        }

        NTT.ntt(LL_A, false);
        NTT.ntt(LL_B, false);

        for (int i = 0; i < n; i++) {
            LL_A[i] = LL_A[i] * LL_B[i] % NTT.MOD;
        }

        NTT.ntt(LL_A, true);

        long[] res = new long[lenA + lenB];
        for (int i = 0; i < lenA + lenB - 1; i++) {
            res[i] = LL_A[i];
        }

        for (int i = 0; i < lenA + lenB - 1; i++) {
            if (res[i] >= 10) {
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
        }
        boolean leadingZero = true;

        for(int i=res.length-1; i>=0; i--) {
            if(leadingZero && res[i] == 0) continue;
            leadingZero = false;
            sb.append(res[i]);
        }

        if(sb.length()==0) sb.append(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}