/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class Package implements Comparable<Package> {
        int from, to, weight;

        public Package(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Package o) {
            if (this.to == o.to) return this.from - o.from;
            return this.to - o.to;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, C, M, from, to, weight, res;
    static Package[] packages;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_8980_택배/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        packages = new Package[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            packages[i] = new Package(from, to, weight);
        }

        Arrays.sort(packages, 1, M + 1);

        int[] availableC = new int[N+1];
        Arrays.fill(availableC, C);

        for (int i = 1; i <= M; i++) {
            Package currP = packages[i];

            int minC = C;
            // 그 구간에서 옮길 수 있는 양
            for(int j= currP.from; j< currP.to; j++) {
                minC = Math.min(minC, availableC[j]);
            }

            // 배송할 양 결정 (그 구간에서 옮길 수 있는 최소값 or 현재 패키지 박스양 중 최솟값)
            int selectedC = Math.min(currP.weight, minC);

            if(selectedC > 0){
                for(int k= currP.from; k<currP.to; k++) {
                    availableC[k] -= selectedC;
                }
                res += selectedC;
            }
        }

        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }
}