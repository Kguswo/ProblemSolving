/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, S[];
    static boolean[] visited, isNum;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_14225_부분수열의합/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        isNum = new boolean[100000*20 + 1];

        dfs(0, 0);
        for(int i = 0; i < isNum.length; i++) {
            if(!isNum[i]) {
                System.out.println(i);
                break;
            }
        }
        br.close();
    }

    private void dfs(int depth, int sum) {
        if(depth == N){
            isNum[sum] = true;
            return;
        }

        dfs(depth + 1, sum + S[depth]);
        dfs(depth + 1, sum);
    }


}