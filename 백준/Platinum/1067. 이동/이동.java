/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static class Complex {
        double real, imag;
        static final double EPS = 1e-9;

        Complex(double real, double imag) {
            this.real = real;
            this.imag = imag;
        }

        Complex add(Complex o) {
            return new Complex(real + o.real, imag + o.imag);
        }

        Complex subtract(Complex o) {
            return new Complex(real - o.real, imag - o.imag);
        }

        Complex multiply(Complex o) {
            double r = real * o.real - imag * o.imag;
            double i = real * o.imag + imag * o.real;
            if (Math.abs(r) < EPS) r = 0;
            if (Math.abs(i) < EPS) i = 0;
            return new Complex(r, i);
        }

        Complex divide(double d) {
            return new Complex(real / d, imag / d);
        }
    }

    static void fft(Complex[] a, boolean invert) {
        int n = a.length;

        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            while (j >= bit) {
                j -= bit;
                bit >>= 1;
            }
            j += bit;
            if (i < j) {
                Complex temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            Complex wlen = new Complex(Math.cos(ang), Math.sin(ang));

            for (int i = 0; i < n; i += len) {
                Complex w = new Complex(1, 0);
                for (int j = 0; j < len/2; j++) {
                    Complex u = a[i + j];
                    Complex v = a[i + j + len/2].multiply(w);

                    a[i + j] = u.add(v);
                    a[i + j + len/2] = u.subtract(v);

                    w = w.multiply(wlen);
                }
            }
        }

        if (invert) {
            for (int i = 0; i < n; i++) {
                a[i] = a[i].divide(n);
            }
        }
    }
    
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static final double EPS = 1e-9;

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

        Complex[] x = new Complex[size];
        Complex[] y = new Complex[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long val = Long.parseLong(st.nextToken());
            x[i] = new Complex(val, 0);
            x[i + n] = new Complex(val, 0);
        }
        for (int i = 2*n; i < size; i++) {
            x[i] = new Complex(0, 0);
        }

        st = new StringTokenizer(br.readLine());
        long[] temp = new long[n];
        for (int i = 0; i < n; i++) {
            temp[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            y[i] = new Complex(temp[n-1-i], 0);
        }
        for (int i = n; i < size; i++) {
            y[i] = new Complex(0, 0);
        }

        fft(x, false);
        fft(y, false);

        for (int i = 0; i < size; i++) {
            x[i] = x[i].multiply(y[i]);
        }

        fft(x, true);

        long max = Long.MIN_VALUE;
        for (int i = n-1; i < 2*n-1; i++) {
            double val = Math.abs(x[i].real) < EPS ? 0 : x[i].real;
            max = Math.max(max, Math.round(val));
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}