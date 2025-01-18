/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, u, v;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_20955_민서의응급수술/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        int res = 0; // 연산횟수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(find(u) == find(v)) res++;
            else union(u, v);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=N; i++) {
            set.add(find(i));
        }
        res += set.size()-1;

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private int find(int x) {
        if(parent[x] != x) return parent[x] = find(parent[x]);
        return x;
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x > y) parent[x] = y;
            else parent[y] = x;
        }
    }
}