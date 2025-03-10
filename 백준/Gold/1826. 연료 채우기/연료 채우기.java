/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Station implements Comparable<Station>{
        int pos, gas;
        public Station(int pos, int gas){
            this.pos = pos;
            this.gas = gas;
        }

        @Override
        public int compareTo(Station o){
            return this.pos - o.pos;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, L, P, res;
    static Station[] stations;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1826_연료채우기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        stations = new Station[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(stations);
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if (P >= L) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int currPos = 0;
        int currGas = P;
        boolean isFinished = false;
        int idx = 0;

        while(!isFinished) {
            while(idx < N && stations[idx].pos <= currPos + currGas) {
                pq.offer(stations[idx].gas);
                idx++;
            }

            if (pq.isEmpty()) {
                res = -1;
                break;
            }

            currGas += pq.poll();
            res++;

            if(currPos + currGas >= L) isFinished = true;
        }

        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }
}