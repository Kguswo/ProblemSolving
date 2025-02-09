/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int res = 1;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2487_섞기수열/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int len = 0;
                for (int j = i; !visited[j]; j = arr[j]) {
                    visited[j] = true;
                    len++;
                }
                res = LCM(res, len);
            }
        }

        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int GCD(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    private static int LCM(int a, int b){
        return a / GCD(a, b) * b;
    }
}