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
    static int N, M, degree[]; // degree : 선행문제수 진입차수배열
    static ArrayList<Integer>[] probs;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1766_문제집/input.txt")));
//        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1-based;
        degree = new int[N+1];
        probs = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            probs[i] = new ArrayList<>();
        }

        int A, B;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // A문제는 B문제보다 먼저 풀어야함
            probs[A].add(B);
            degree[B]++;
        }

        // 풀 문제
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N+1; i++) {
            if(degree[i] == 0) pq.add(i);
        }

        while(!pq.isEmpty()) {
            int currP = pq.poll();
            sb.append(currP + " ");
            for(int p : probs[currP]) {
                degree[p]--;
            }

            degree[currP]--;
            for(int nextP : probs[currP]) {
                if(degree[nextP] == 0) pq.add(nextP);
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}