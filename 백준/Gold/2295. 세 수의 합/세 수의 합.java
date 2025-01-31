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
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2295_세수의합/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            for(int j=0 ; j < N; j++){
                set.add(arr[i] + arr[j]);
            }
        }

//        System.out.println(set);

        int res = 0;
        for(int k=N-1; k>=0; k--){
            for(int i=0; i<N; i++){
                if(set.contains(arr[k]-arr[i])){
                    res = Math.max(res, arr[k]);
                }
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}