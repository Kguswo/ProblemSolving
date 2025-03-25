/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, arr[];
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2661_좋은수열/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[81]; // 1-based

        makeNum(1);

        bw.flush();
        bw.close();
        br.close();
    }

    void makeNum(int idx){
        if(flag) return;

        if(idx > N) {
            for(int i=1; i<=N; i++) {
                System.out.print(arr[i]);
            }
            flag = true;
            return;
        }

        for(int i=1; i<=3; i++){
            if(arr[idx-1] == i) continue;
            arr[idx] = i;
            if(isValid(idx)) makeNum(idx+1);
        }
    }

    boolean isValid(int idx) {
        int cnt = 0;
        for(int i=2; i<=idx/2; i++){ // 부분수열 길이 2~ idx/2까지
            for(int j=1; j<=idx-i; j++){ // 시작인덱스
                cnt = 0;
                for(int k=j; k<=j+i-1; k++){ // 첫 부분수열
                    if(k+i > idx) continue;
                    if(arr[k] == arr[k+i]) cnt++; // ex) 1-4 / 2-5 / 3-6
                }
                if(cnt == i) return false;
            }
        }
        return true;
    }
}