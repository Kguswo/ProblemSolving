/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Meat implements Comparable<Meat>{
        int w, p;
        public Meat(int w, int p) {
            this.w = w;
            this.p = p;
        }

        @Override
        public int compareTo(Meat o) {
            if(this.p == o.p) return o.w - this.w;
            return this.p - o.p;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    static long res = Long.MAX_VALUE;
    static Meat[] meat;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2258_정육점/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        meat = new Meat[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meat[i] = new Meat(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meat);

        int prevP=0;
        int Wsum=0;
        int currP=0;
        for(Meat m : meat) {
            if(m.p > prevP) {
                prevP = m.p;
                currP = m.p;
            }
            else if(m.p == prevP) currP+=m.p;

            Wsum += m.w;

            if(Wsum >= M) res = Math.min(res, currP);
        }

        if (Wsum < M || res > 2_147_483_647) res = -1;

        System.out.println(res);

        br.close();
    }
}