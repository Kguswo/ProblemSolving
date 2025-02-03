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
    static int T, N, arr[];
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_13423_ThreeDots/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int cnt = 0;
            for(int i = 0; i < N-2; i++) {
                for(int j = i + 2; j < N; j++) {
                    long target = (long) arr[i] + ((long) arr[j] - (long) arr[i]) / 2;
                    if((arr[j] - arr[i]) % 2 == 0 && binarySearch(i+1, j-1, target)){
                        cnt++;
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean binarySearch(int left, int right, long target) {
        boolean flag = false;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == arr[mid]) {
                flag = true;
                break;
            }
            else if(target < arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return flag;
    }
}