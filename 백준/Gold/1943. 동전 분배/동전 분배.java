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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1943_동전분배/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t=0; t<3; t++){
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[100001];
            dp[0] = 1;
            int total = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());

                total += price * number;

                for(int j = 0; j < number; j++) {
                    for(int k = 50000; k >= price; k--) {
                        if(dp[k - price] == 1) {
                            dp[k] = 1;
                        }
                    }
                    if(dp[total/2] == 1) break;
                }
            }

            if(total % 2 == 1){
                System.out.println(0);
            }
            else{
                if(dp[total/2]==1) System.out.println(1);
                else System.out.println(0);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}