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
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2877_4와7/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long K = Long.parseLong(br.readLine());

        int digits = 1;
        long sum = 0;

        while(true){
            long cnt = 1L << (digits);

            if(sum + cnt >= K) break;

            sum += cnt;
            digits++;
        }

        long pos = K - sum - 1; // K-sum 번째이므로 인덱스로는 -1

        for(int i=0; i<digits; i++){ // 맨 오른쪽 자릿수부터 숫자찾기, 0이면 작은수 1이면 큰수
            if((pos & (1L << (digits - 1 - i))) == 0) sb.append("4");
            else sb.append("7");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
