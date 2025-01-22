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
    int G, maxN;
    int a, b, n, m;
    static TreeSet<Integer> tset;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1484_다이어트/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        G = Integer.parseInt(br.readLine());
        maxN = (G + 1) / 2;

        tset = new TreeSet<>();

        for (int i = 1; i <= (int) Math.sqrt(G); i++) {
            if (G % i == 0) {
                a = G / i;
                b = i;

                n = (a + b)/2;
                m = (a - b)/2;

                if((a + b) % 2 == 0 && (a - b) % 2 == 0) {
                    if(m > 0)
                        tset.add(n);
                }
            }
        }

        sb.append(tset.isEmpty() ? -1 : print());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private String print(){
        StringBuilder tmp = new StringBuilder();
        for (int n : tset) {
            tmp.append(n).append("\n");
        }
        return tmp.toString();
    }
}