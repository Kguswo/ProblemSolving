/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, S;
    static int[] arr1, arr2;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1208_부분수열의합2/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr1 = new int[N / 2];
        arr2 = new int[N - arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Long> arr1CombCnt = new HashMap<>();
        for (int i = 0; i < (1 << arr1.length); i++) {
            int sum = 0;
            for (int j = 0; j < arr1.length; j++) {
                if ((i & (1 << j)) != 0) sum += arr1[j];
            }
            arr1CombCnt.put(sum, arr1CombCnt.getOrDefault(sum, 0L) + 1);
        }

        long res = 0;

        for (int i = 0; i < (1 << arr2.length); i++) {
            int sum = 0;
            for (int j = 0; j < arr2.length; j++) {
                if ((i & (1 << j)) != 0) sum += arr2[j];
            }
            int target = S - sum;
            if (arr1CombCnt.containsKey(target)) res += arr1CombCnt.get(target);
        }
        if (S == 0) res--;
        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }
}