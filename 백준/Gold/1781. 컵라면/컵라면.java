/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Work implements Comparable<Work> {
        int deadline, ramen;
        public Work(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Work o) {
            if(this.deadline == o.deadline){
                return o.ramen - this.ramen;
            }
            return this.deadline - o.deadline;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, d, r, beforeTime=0, currTime=0;
    static long maxRamen;
    static PriorityQueue<Work> pq = new PriorityQueue<Work>();
    static PriorityQueue<Integer> ramens = new PriorityQueue<Integer>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1781_컵라면/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            beforeTime = Math.max(beforeTime, d);
            pq.add(new Work(d, r));
        }

        while(!pq.isEmpty()) {
            Work currW = pq.poll();
            if(ramens.size() < currW.deadline) {
                ramens.add(currW.ramen);
                maxRamen += currW.ramen;
            }
            else if(!ramens.isEmpty() && ramens.peek() < currW.ramen) { // 꽉 찼는데 최대컵라면만 갱신
                maxRamen -= ramens.poll();
                ramens.add(currW.ramen);
                maxRamen += currW.ramen;
            }
        }

        bw.write(String.valueOf(maxRamen));
        bw.flush();
        bw.close();
        br.close();
    }
}
