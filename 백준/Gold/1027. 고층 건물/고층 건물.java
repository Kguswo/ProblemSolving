/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, h[];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1027_고층건물/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        h = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for(int i=0; i<N; i++) {
            int left = 0, right = 0;

            if(i==0) right = countRight(0);
            else if(i==N-1) left = countLeft(N-1);
            else {
                left = countLeft(i);
                right = countRight(i);
            }

            if(res < left + right) res = left + right;
        }

        System.out.println(res);
        br.close();
    }

    private int countLeft(int idx) {
        int cnt = 0;

        double a = 1000000001; // 기울기
        for(int i=idx-1; i>=0; i--){
            double new_a = (h[idx] - h[i]) / (double) (Math.abs(idx-i));
            if(new_a < a) {
                cnt++;
                a = new_a;
            }

        }
        return cnt;
    }

    private int countRight(int idx) {
        int cnt = 0;

        double a = -1000000001;
        for(int i=idx+1; i<N; i++){
            double new_a = (h[i] - h[idx]) / (double) (Math.abs(idx-i));
            if(a < new_a) {
                cnt++;
                a = new_a;
            }
        }
        return cnt;
    }
}
