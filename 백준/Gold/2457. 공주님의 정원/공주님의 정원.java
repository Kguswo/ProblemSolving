/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Flower implements Comparable<Flower>{
        int start, end;
        public Flower(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if(this.start == o.start) return o.end - this.end;
            return this.start - o.start;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, START, END, res;
    static int[] monthPrefix = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30}; // 1~11월
    static Flower[] flowers;
    static boolean flag=true; // 가능하면 true
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2457_공주님의정원/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // m월 0일
        for(int i=1; i<monthPrefix.length; i++) {
            monthPrefix[i] += monthPrefix[i-1];
        }
//        System.out.println(Arrays.toString(monthPrefix));
        START = monthPrefix[2] + 1;
        END = monthPrefix[10] + 30;

        N = Integer.parseInt(br.readLine());
        flowers = new Flower[N];
        int m1, d1, m2, d2;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            m1 = Integer.parseInt(st.nextToken());
            d1 = Integer.parseInt(st.nextToken());
            m2 = Integer.parseInt(st.nextToken());
            d2 = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(monthPrefix[m1-1] + d1, monthPrefix[m2-1] + d2);
        }

        Arrays.sort(flowers);

        int currEnd = START;
        int idx = 0;
        while(currEnd <= END && flag) {
            int nextEnd = currEnd;
            while(idx < N && flowers[idx].start <= currEnd){
                if(nextEnd < flowers[idx].end){
                    nextEnd = flowers[idx].end;
                }
                idx++;
            }

            // 발전이 없음
            if(nextEnd == currEnd) flag = false;
            else {
                res++;
                currEnd = nextEnd;
            }
        }
        System.out.println(flag? res : 0);
        bw.flush();
        bw.close();
        br.close();
    }
}