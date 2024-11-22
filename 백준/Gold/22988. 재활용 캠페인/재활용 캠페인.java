/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N;
    static long X, arr[];
    static double HALF = 0;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        HALF = X / 2.0;
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        boolean flag = false;
        int left = 0;
        int right = N - 1;
        int remainingCnt = N;

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        arr = Arrays.stream(arr)
                .sorted()
                .toArray();

        for (int i = 0; i < N; i++) {
            if (arr[i] >= X && !flag) {
                right = i-1;
                flag = true;
                remainingCnt = i;
            }
        }

        if (!flag) right = N - 1;
        int res = flag ? N - (right+1) : 0;

        while (left < right) {
            if (arr[left] + arr[right] >= HALF) {
            	remainingCnt -= 2;
                res++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        
        if (remainingCnt > 0) {
            res += remainingCnt / 3 ;
        }
        

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}