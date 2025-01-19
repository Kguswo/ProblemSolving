/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main  {
    class Node implements Comparable<Node>{
        int from, to, weight;
        public Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return o.weight - weight;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, p[];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1939_중량제한/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        for (int i=1; i<=N; i++) {
            p[i] = i;
        }

        ArrayList<Node> nodes = new ArrayList<Node>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.add(new Node(a, b, w));
        }
        Collections.sort(nodes);

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int res = 0;
        for(Node n : nodes){
            union(n.from, n.to);
            if(find(start) == find(end)){
                res = n.weight;
                break;
            }
        }
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x){
        if(x != p[x]) return p[x] = find(p[x]);
        return p[x];
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py) {
            if(px > py) p[py] = p[px];
            else p[px] = py;
        }
    }
}