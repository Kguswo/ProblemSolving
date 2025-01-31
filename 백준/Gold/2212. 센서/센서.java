/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K, arr[], len[], res;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2212_센서/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        // K>=Ndl면 각각 설치할 수 있으므로 0
        if (K >= N) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        
        arr = new int[N];
        len = new int[N-1];
        st = new StringTokenizer(br.readLine());
        res = 0;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0; i<N-1; i++) {
            len[i] = arr[i+1]-arr[i];
            res += len[i];
        }

        Arrays.sort(len);
        for(int i=len.length-1; i>len.length-1-(K-1); i--){
            res -= len[i];
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}