/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, honey[], maxH, totalH, prefixSum[], max;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_21758_꿀따기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        honey = new int[N];
        prefixSum = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            if(maxH < honey[i]) maxH = honey[i];
            totalH += honey[i];
        }

        // 벌통 맨 왼쪽
        // basket = 0, fixedBee = N-1;
        prefixSum[0] = honey[0];
        for(int i=1; i<=N-2; i++){
            prefixSum[i] = prefixSum[i-1] + honey[i];
        }
        for(int i=1; i<=N-2; i++){
            if(prefixSum[N-2] + (prefixSum[i-1] - honey[i]) > max) max = prefixSum[N-2] + prefixSum[i-1] - honey[i];
        }

        // 벌통 맨 오른쪽
        Arrays.fill(prefixSum, 0);
        prefixSum[N-1] = honey[N-1];
        for(int i=N-2; i>=1; i--){
            prefixSum[i] = prefixSum[i+1] + honey[i];
        }
        for(int i=1; i<=N-2; i++){
            if(prefixSum[1] + (prefixSum[i+1] - honey[i]) > max) max = prefixSum[1] + prefixSum[i+1] - honey[i];
        }

        // 벌 좌우 맨 끝
        max = Math.max(max, totalH - honey[0] - honey[N-1] + maxH);

        System.out.println(max);
        bw.flush();
        bw.close();
        br.close();
    }
}
