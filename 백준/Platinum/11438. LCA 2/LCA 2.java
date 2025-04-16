/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, maxH;
    static int[] depth;
    static int[][] dp;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11438_LCA2/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        // 트리의 maxH
        for(int i=1; i<=N; i*=2){
            maxH++;
        }

        dp = new int[N+1][maxH];
        depth = new int[N+1];

        tree = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        initTree(1, 1, 0);
        initParent();

        M = Integer.parseInt(br.readLine());
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(LCA(a, b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int LCA(int a, int b) {
        int a_h = depth[a];
        int b_h = depth[b];

        // a높이 항상 크게 유지
        if(a_h < b_h){
            int tmp = a;
            a = b;
            b = tmp;
        }

        //같은 높이에서 시작하게 높이 맞추기
        for(int i=maxH-1; i>=0; i--){
            a_h = depth[a];
            b_h = depth[b];
            int depthGap = a_h - b_h;

            if(Math.pow(2, i) <= depthGap) a = dp[a][i]; //희소 배열처럼 점프
        }

        if(a==b) return a;

        // 같은 부모 가리킬때까지 위로 진행 (같은 높이)
        for(int i=maxH-1; i>=0; i--){
            if(dp[a][i] != dp[b][i]){
                a = dp[a][i];
                b = dp[b][i];
            }
        }

        return dp[a][0];
    }

    private void initParent() { // dp(부모저장2차원배열) 점화식
        for(int h=1; h<maxH; h++){
            for(int node=1; node<=N; node++){
                dp[node][h] = dp[dp[node][h-1]][h-1]; // node의 2^h번째 부모 = (node의 부모)의 2^(h-1)번째 부모
            }
        }
    }

    private static void initTree(int child, int parent, int d) { // 재귀적으로 아래로 내려가며 트리 형태 만들기
        depth[child] = d;
        dp[child][0] = parent;
        for(int next : tree[child]){
            if(next == parent) continue;
            initTree(next, child, d+1);
        }
    }


}