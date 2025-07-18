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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/제9회천하제일코딩대회본선OpenContest/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int first = arr[0];

        int min = first;
        int max = first;
        
        for(int i=1; i<N; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        if(first == min) System.out.println("ez");
        else if(first == max) System.out.println("hard");
        else System.out.println("?");
        
        bw.flush();
        bw.close();
        br.close();
    }
}