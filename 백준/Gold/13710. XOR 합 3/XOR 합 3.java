/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static long[] prefixSumXOR;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_13710_XOR합3/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        // 누적 XOR 배열 (XOR합 위해 0 포함)
        prefixSumXOR = new long[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int a = Integer.parseInt(st.nextToken());
            prefixSumXOR[i] = prefixSumXOR[i-1] ^ a;
        }
        
        // 각 비트별 1 개수
        int[] oneCnt = new int[30];
        
        for(int i=0; i<30; i++){
            for(int j=0; j<=N; j++){
                if((prefixSumXOR[j] & (1L<<i)) != 0) oneCnt[i]++;
            }
        }
        
        long res = 0;
        for(int i=0; i<30; i++){
            // i번쨰 비트에서 : 1개수 x 0개수 x 2^i
            res += (1L<<i) * oneCnt[i] * (N+1-oneCnt[i]);
        }
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}