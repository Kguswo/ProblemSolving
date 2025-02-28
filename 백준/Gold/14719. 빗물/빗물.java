/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int H, W, height[], maxL, maxR, maxBoard[][], res;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_14719_빗물/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        maxBoard = new int[W][2];
        maxL = height[0];
        maxR = height[W - 1];

        for (int i = 0; i < W; i++) {
            maxL = (int) Math.max(maxL, height[i]);
            maxBoard[i][0] = maxL;
        }

        for (int i = W-1; i >= 0; i--) {
            maxR = (int) Math.max(maxR, height[i]);
            maxBoard[i][1] = maxR;
        }

        int minH; // 각 인덱스에서 좌우 최대높이 중 작은값 (물이 찰 높이)
        for (int i = 0; i < W; i++) {
            minH = Math.min(maxBoard[i][0], maxBoard[i][1]);
            int water = minH - height[i];
            res += (water > 0 ? water : 0);
        }
        System.out.println(res);
        bw.flush();
        bw.close();
        br.close();
    }
}