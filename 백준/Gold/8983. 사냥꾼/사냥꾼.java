/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int M, N, L;
    static TreeSet<Integer> tset = new TreeSet<>();
    static List<int[]> animals = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_8983_사냥꾼/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            tset.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals.add(new int[]{x, y});
        }
        int res = 0;
        for(int[] a : animals) {
            int v = L - a[1];
            if(v<0) continue;

            int left, right;
            left = 0;
            right = 0;

            left = Math.max(1, a[0] - v);
            right = Math.min(1_000_000_000, a[0] + v);

            if(tset.ceiling(left) != null && tset.ceiling(left) <= right) res++;
        }
        System.out.println(res);
        br.close();
    }
}