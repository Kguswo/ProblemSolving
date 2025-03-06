/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr, res;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_24523_내뒤에나와다른수/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = new int[N+1];
        Arrays.fill(res, -1);

        for(int i = 1; i < N+1; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] != arr[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }

        for(int i=1; i <= N; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}