/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, K, A, B, arr[], res;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_23351_물주기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N];
        Arrays.fill(arr, K);
        boolean flag = false;
        while(!flag){
            res++;

            int startIdx = findMinSet();
            waterPlants(startIdx);
            flag = checkEnd();
        }
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }

    private int findMinSet() {
        int idx = -1;
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i <= N-A; i++) {
            int tmp = 0;
            for (int j = i; j < i+A; j++) {
                tmp += arr[j];
            }
            if(tmp < sum){
                sum = tmp;
                idx = i;
            }
        }
        return idx;
    }

    private void waterPlants(int startIdx) {
        for(int i = startIdx; i < startIdx + A; i++){
            arr[i] += B;
        }
    }

    private boolean checkEnd() {
        for(int i = 0; i < N; i++){
            arr[i]--;
            if(arr[i] <= 0) return true;
        }
        return false;
    }
}