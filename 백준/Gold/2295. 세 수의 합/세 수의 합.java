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

        int left, right, res=0;
        for(int i = N-1; i >= 0; i--){
            for(int j=i-1; j>=0; j--){
                for(int k=0; k<=j; k++){
                    if(arr[i]-(arr[j]+arr[k]) <= 0) break;
                    left = 0;
                    right = k;
                    while(left <= right){
                        int mid = left + (right - left)/2;
                        if(arr[mid] >= arr[i]-(arr[j]+arr[k])){
                            right = mid - 1;
                            res = mid;
                        }
                        else{
                            left = mid + 1;
                        }
                    }

                    if(arr[res] == arr[i]-(arr[j]+arr[k])){
                        System.out.println(arr[i]);
                        return;
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}