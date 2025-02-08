/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long res;
    static boolean flag = false;
    static int[][] board; // [A, C, B] 저장
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1637_날카로운눈/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][3];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }
        
        long left = 1;
        long right = 2147483647;

        while(left<=right) {
            long mid = left + (right - left)/2;
            long cnt = getCnt(mid);

            if(cnt % 2 == 0) left = mid + 1;
            else {
                res = mid;
                right = mid - 1;
                if(!flag) flag = true;
            }
        }

        if(!flag)  sb.append("NOTHING");
        else {
            long ans = getCnt(res) - getCnt(res-1);
            sb.append(res).append(" ").append(ans);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private long getCnt(long mid) { // mid보다 작거나 같은 수들의 총 개수
        if(mid < 1) return 0;

        long sum = 0;

        long A, B, C;
        for(int i=0; i<N; i++){
            A = board[i][0];
            C = board[i][1];
            B = board[i][2];
            if(mid < A) continue;
            if(mid > C) sum += (C-A)/B + 1;
            else sum += (mid-A)/B + 1;
        }
        return sum;
    }
}
