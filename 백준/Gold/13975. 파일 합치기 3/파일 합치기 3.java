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
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_13975_파일합치기3/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T--> 0) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            long min = 0;
            while(pq.size() >=2) {
                Long tmp1 = pq.poll();
                Long tmp2 = pq.poll();
                tmp1 += tmp2;
                min += tmp1;
                pq.add(tmp1);
            }
            sb.append(min).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}