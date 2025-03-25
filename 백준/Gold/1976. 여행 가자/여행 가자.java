/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] p;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1976_여행가자/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        for(int i = 0; i < N+1; i++) {
            p[i] = i;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = i;
            for (int v=1; v<=N; v++) {
                int connetion = Integer.parseInt(st.nextToken());
                if(connetion==1) {
                    if(find(u) != find(v)) union(u,v);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());

        boolean isAble = true;
        for (int i = 1; i < M; i++) {
            int nc = Integer.parseInt(st.nextToken());
            if(find(c) != find(nc)){
                isAble = false;
                break;
            }
        }

        if(isAble) System.out.println("YES");
        else System.out.println("NO");

        br.close();
    }

    private int find(int x){
        if(p[x] != x) return p[x] = find(p[x]);
        return p[x];
    }

    private void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px != py) {
            if (px < py) p[py] = px;
            else p[px] = py;
        }
    }
}