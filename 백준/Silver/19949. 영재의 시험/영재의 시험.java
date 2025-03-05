/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int arr[], select[], res;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_19949_영재의시험/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[10];
        select = new int[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }

    private void dfs(int idx, int cnt) {
        if(idx == 10){
            if(cnt >= 5) {
                res++;
            }
            return;
        }

        for(int i=1; i<=5; i++){
            if(idx >= 2 && select[idx-2] == i && select[idx-1] == i) continue;

            select[idx] = i;

            if(arr[idx] == i) dfs(idx+1, cnt+1);
            else dfs(idx+1, cnt);
        }
    }
}