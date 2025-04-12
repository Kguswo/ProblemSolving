/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1205_등수구하기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        if(N==0){
            System.out.println(1);
            return;
        }

        Integer[] arr = new Integer[size];
        Arrays.fill(arr, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        boolean flag = false;
        for(int i=0; i<size; i++){
            if(arr[i] >= num) continue;
            else {
                arr[i] = num;
                flag = true;
            }
        }
        if(!flag) {
            System.out.println("-1");
            return;
        }
        else{
            for(int i=0; i<size; i++){
                if(arr[i] == num) {
                    System.out.println(i+1);
                    return;
                }
            }
        }

        br.close();
    }
}