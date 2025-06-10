/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] prefixSum, cnt;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_24525_SKK문자열/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        prefixSum = new int[s.length() + 1];
        cnt = new int[s.length() + 1];

        prefixSum[0] = 0;
        cnt[0] = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'S'){
                prefixSum[i+1] = prefixSum[i] + 2;
                cnt[i+1] = cnt[i] + 1;
            }
            else if(c == 'K'){
                prefixSum[i+1] = prefixSum[i] - 1;
                cnt[i+1] = cnt[i] + 1;
            }
            else {
                prefixSum[i+1] = prefixSum[i];
                cnt[i + 1] = cnt[i];
            }
        }
        
        Map<Integer, Integer> minIdx = new HashMap<>();
        int res = -1;

        for(int i=0; i<=s.length(); i++){
            if(!minIdx.containsKey(prefixSum[i])) minIdx.put(prefixSum[i], i);
            else{
                int min = minIdx.get(prefixSum[i]);
                if(cnt[i] > cnt[min]){
                    res = Math.max(res, i-min);
                }
            }
        }

        System.out.println(res);
        br.close();
    }
}