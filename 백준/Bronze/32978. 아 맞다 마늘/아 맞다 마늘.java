/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Set<String> ingredients = new HashSet<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_32978_아맞다마늘/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N-1; i++) {
            ingredients.add(st.nextToken());
        }

        for(String s : arr) {
            if(!ingredients.contains(s)) {
                System.out.println(s);
                return;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
