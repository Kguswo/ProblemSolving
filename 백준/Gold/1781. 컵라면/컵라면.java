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
            /*
            데드라인까지 개수 부족하게는 넣을 수 있음 (데드라인 1 3 5 세개면 다 가능)
            근데 데드라인 오버되도록 진행하면 문제가 발생
            예를들어
            1 4
            2 5
            3 6
            3 7
            이런경우에는 최적해가 5 6 7 로 진행해야함../ 데드라인이 최대 그날까진 해야한다이므로 그 전에 더 높은거 해도됨
            그러므로 이런 경우에는 고른 라면중에 제일 적게 받은과제를 빼고 이번에 고른걸 선택
             */
            if(ramens.size() < currW.deadline) {
                ramens.add(currW.ramen);
                maxRamen += currW.ramen;
            }
            else if(!ramens.isEmpty() && ramens.peek() < currW.ramen) { // 최저 컵라면 교체
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
