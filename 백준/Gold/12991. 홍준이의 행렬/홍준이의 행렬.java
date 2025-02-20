/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K;
    static long res;
    static long[] A, B;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_12991_홍준이의행렬/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new long[N];
        B = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        long left, right;
        left = A[0] * B[0];
        right = A[N - 1] * B[N - 1];

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (count(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean count(long target) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int tmp = 0;
            int left = 0, right = N - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (A[i] * B[mid] <= target) {
                    tmp = mid + 1;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            cnt += tmp;
        }
        return cnt >= K;
    }
}