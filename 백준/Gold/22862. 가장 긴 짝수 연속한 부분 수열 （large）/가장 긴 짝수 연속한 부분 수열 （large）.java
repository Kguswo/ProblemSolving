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
    static int N, K, arr[], oddCnt;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_22862_가장긴짝수연속한부분수열large/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] % 2 == 1) oddCnt++;
        }

        if(N == 1){
            if(oddCnt == 1) {
                sb.append(0).append("\n");
                bw.write(sb.toString());
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            else{
                sb.append(1).append("\n");
                bw.write(sb.toString());
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }
        else{
            if(oddCnt <= K) {
                sb.append(N-oddCnt).append("\n");
                bw.write(sb.toString());
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            else{
                int left=0;
                int right=0;
                int cnt = K;
                int evenCnt = 0;
                int maxLen = 0;
                while(right < N && left <= right){
                    if(arr[right] % 2 == 0){ // 오른쪽 짝수일때
                        evenCnt++;
                        right++;
                    }
                    else{ // 오른쪽 홀수일때
                        if(cnt > 0) { // 홀수 더 지울 수 있을때
                            cnt--;
                            right++;
                        }
                        else{ // 홀수 지울 수 없을때는 왼쪽줄여야됨
                            if(arr[left] % 2 == 0) { // 왼쪽짝수없애기
                                evenCnt--;
                                left++;
                            }
                            else{ // 왼쪽홀수없애기
                                cnt++;
                                left++;
                            }
                        }
                    }
                    maxLen = Math.max(maxLen, evenCnt);
                }
                sb.append(maxLen).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}