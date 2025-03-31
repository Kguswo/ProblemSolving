/**
 * Author: nowalex322, Kim HyeonJae
 * 20:25 ~ 21:05
 */

import java.io.*;
import java.util.*;

public class Main {
    class Lecture implements Comparable<Lecture>{
        int day, pay;
        public Lecture(int day, int pay){
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.pay - this.pay;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2109_순회강연/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[n];
        int maxD = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            maxD = Math.max(maxD, d);
            lectures[i] = new Lecture(d, p);
        }
        Arrays.sort(lectures);

        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=1; i<=maxD; i++){
            ts.add(i);
        }

        int res = 0;
        for(Lecture l : lectures){
            int ableD = ts.floor(l.day)==null ? 0 : ts.floor(l.day);
            ts.remove(ableD);
            if(ableD != 0) res += l.pay;
        }
        System.out.println(res);
        br.close();
    }
}