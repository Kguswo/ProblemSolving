/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, dasom, res = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1417_국회의원선거/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(0);
            return;
        }

        dasom = Integer.parseInt(br.readLine());
        for(int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }

        while(!pq.isEmpty() && dasom <= pq.peek()) {
            int tmp = pq.poll();
            dasom ++;
            res ++;
            pq.add(tmp-1);
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}