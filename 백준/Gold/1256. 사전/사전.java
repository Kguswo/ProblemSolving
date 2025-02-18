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
    static int N, M, K, res;
    static long combCnt;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1256_사전/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        combCnt = combCnt(N+M, N, M);
        if(K > combCnt) {
            System.out.println(-1);
            return;
        }

        int aCnt=N, zCnt=M;

        long cnt = 0;
        for(int i=0; i<N+M; i++){

            if(aCnt == 0) {
                sb.append('z');
                continue;
            }
            else if(zCnt == 0){
                sb.append('a');
                continue;
            }

            if(aCnt > 0) cnt = combCnt(aCnt + zCnt - 1, aCnt -1, zCnt);

            if(K <= cnt){
//                System.out.println("cnt = " + cnt);
                sb.append('a');
//                System.out.println(sb);
                aCnt--;
            }
            else{
//                System.out.println("cnt = " + cnt);
                sb.append('z');
//                System.out.println(sb);
                zCnt--;
                K -= cnt;
//                System.out.println("K = " + K);
            }
        }
        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }

    private long combCnt(int total, int a, int z) {
        int m = Math.min(a, z);
        long cnt=1;
        for(int i=1; i<=m; i++) {
//            if(cnt >= Long.MAX_VALUE/(total-m+i)) return 1000000001;
            cnt = cnt * (total-m+i)/i;
            if(cnt > 1000000000) return 1000000001;
        }
        return cnt;
    }
}