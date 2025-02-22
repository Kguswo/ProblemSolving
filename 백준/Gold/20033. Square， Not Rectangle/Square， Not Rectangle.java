/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, H[];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_20033_SquareNotRectangle/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        H = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = N;
        int res = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isAble(mid)){
                res = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean isAble(int mid) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(mid <= H[i]) {
                cnt++;
                if(cnt >= mid) return true;
            }
            else cnt = 0;
        }
        return false;
    }
}