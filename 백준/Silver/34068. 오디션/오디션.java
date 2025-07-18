/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/제9회천하제일코딩대회본선OpenContest/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] score = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            score[a]++;
        }

        int[] currScore = new int[N];
        for (int i = 1; i <= N; i++) {
            currScore[i - 1] = score[i];
        }

        Arrays.sort(currScore);

        long res = 0;

        for (int i = 0; i < N; i++) {
            int curr = currScore[i];
            int min;

            if (i == 0) min = curr;
            else min = Math.max(curr, currScore[i-1] + 1);


            currScore[i] = min;

            if (min > curr) res += (min - curr);

        }

        System.out.println(res);

        bw.flush();
        bw.close();
        br.close();
    }
}