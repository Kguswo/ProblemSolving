/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    class People implements Comparable<People> {
        int idx, x, y, sum;

        public People(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.sum = x + y;
        }

        public int compareTo(People o) {
            return o.sum - this.sum;
        }
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_7568_덩치/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        People[] people = new People[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            people[i] = new People(i, x, y);
        }

        Arrays.sort(people);

        int[] res = new int[N];

        for (int i = people.length - 1; i >= 0; i--) {
            int idx = people[i].idx;
            int currX = people[i].x;
            int currY = people[i].y;

            int rank = i + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (people[j].x <= currX || people[j].y <= currY) {
                    rank--;
                }
            }

            res[idx] = rank;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
