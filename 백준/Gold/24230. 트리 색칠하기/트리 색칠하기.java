/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, node, a, b, res;
    static int[] colors;
    static List<Integer>[] tree;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_24230_트리색칠하기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        colors = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0, 0);

        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int curr, int parent, int color) {
        if(colors[curr] != colors[parent]) res++;

        for(int node : tree[curr]) {
            if(node != parent) dfs(node, curr, colors[curr]);
        }
    }
}