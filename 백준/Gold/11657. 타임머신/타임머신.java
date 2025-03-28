/**
 * Author: nowalex322, Kim HyeonJae
 * 15:51 : 16 : 08
 */

import java.io.*;
import java.util.*;

public class Main {
    class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11657_타임머신/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        // 벨만 포드
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0; // 시작 1

        boolean negativeCycle = false; // 음의 사이클 체크 -> -1

        for (int i = 0; i < N - 1; i++) { // N-1개
            for (Edge e : edges) {
                if (dist[e.from] != Long.MAX_VALUE) {
                    if (dist[e.to] > dist[e.from] + e.weight) {
                        dist[e.to] = dist[e.from] + e.weight;
                    }
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.to] != Long.MAX_VALUE) {
                if (dist[e.to] > dist[e.from] + e.weight) {
                    negativeCycle = true;
                    break;
                }
            }
        }

        if (negativeCycle) sb.append("-1");
        else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] != Long.MAX_VALUE) {
                    sb.append(dist[i]).append("\n");
                } else sb.append("-1").append("\n");
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}