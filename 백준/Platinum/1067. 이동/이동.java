/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static class NTT {
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

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1067_이동/input.txt")));        
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int size = 1;
        while (size < 2 * n) size <<= 1;

        long[] x = new long[size];
        long[] y = new long[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Long.parseLong(st.nextToken());
            x[i + n] = x[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long val = Long.parseLong(st.nextToken());
            y[(2*n-1-i) % n] = val;
        }

        NTT.ntt(x, false);
        NTT.ntt(y, false);

        for (int i = 0; i < size; i++) {
            x[i] = x[i] * y[i] % NTT.MOD;
        }

        NTT.ntt(x, true);

        long max = Long.MIN_VALUE;
        for (int i = n-1; i < 2*n-1; i++) {
            long val = x[i];
            if (val < 0) val += NTT.MOD;
            max = Math.max(max, val);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}