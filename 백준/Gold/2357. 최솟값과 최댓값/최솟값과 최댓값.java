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
    static int N, M, h, size;
    static int[] nums, maxTree, minTree;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2357_최댓값과최솟값/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        /*
        높이 : log_2(N) + 1
        배열크기 : 2^h - 1
         */

        h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        size = (int) Math.pow(2, h) - 1;

        maxTree = new int[size];
        minTree = new int[size];

        initMaxTree(1, 1, N);
        initMinTree(1, 1, N);

        int s, e;
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            sb.append(getMin(1, 1, N, s, e)).append(" ").append(getMax(1, 1, N, s, e)).append("\n");
        }
        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }

    private int initMinTree(int node, int start, int end) {
        if (start == end) return minTree[node] = nums[start];

        int mid = start + (end - start) / 2;

        return minTree[node] = Math.min(initMinTree(node * 2, start, mid), initMinTree(node * 2 + 1, mid + 1, end));
    }

    private int initMaxTree(int node, int start, int end) {
        if (start == end) return maxTree[node] = nums[start];

        int mid = start + (end - start) / 2;

        return maxTree[node] = Math.max(initMaxTree(node * 2, start, mid), initMaxTree(node * 2 + 1, mid + 1, end));
    }

    private int getMax(int node, int start, int end, int from, int to) {
        /*
            찾고자 하는 구간 벗어날땐 리턴
            start~end에 속할땐 그 구간 값 반환
            아래로 계속쪼개기
         */
        if (end < from || to < start) return Integer.MIN_VALUE;

        if (from <= start && end <= to) return maxTree[node];

        int mid = start + (end - start) / 2;

        return Math.max(getMax(node * 2, start, mid, from, to), getMax(node * 2 + 1, mid + 1, end, from, to));
    }

    private int getMin(int node, int start, int end, int from, int to) {
        if (end < from || to < start) return Integer.MAX_VALUE;

        if (from <= start && end <= to) return minTree[node];

        int mid = start + (end - start) / 2;

        return Math.min(getMin(node * 2, start, mid, from, to), getMin(node * 2 + 1, mid + 1, end, from, to));
    }
}