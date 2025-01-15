/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    int N;
    static int[] arr, dp, LIS;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_12015_가장긴증가하는부분수열2/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        LIS = new int[N+1];
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 1;
        LIS[1] = arr[1];
        dp[1] = 1;

        int maxLen = 1;
        for(int i = 2; i <= N; i++) {
            if(arr[i] > LIS[idx]) {
                LIS[++idx] = arr[i];
                dp[i] = idx;
            }
            else{
                int pos = binarySearch(1, idx, arr[i]);
                LIS[pos] = arr[i];
                dp[i] = pos;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        sb.append(maxLen).append("\n");
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = N; i >= 1; i--) {
            if(dp[i] == maxLen) {
                res.add(arr[i]);
                maxLen--;
            }
        }
        Collections.reverse(res);
        for(int num : res) {
            sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private int binarySearch(int left, int right, int target) {
        int res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(LIS[mid] < target){
                left = mid + 1;
            }
            else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }
}