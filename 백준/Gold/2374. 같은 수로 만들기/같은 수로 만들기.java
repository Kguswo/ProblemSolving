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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2374_같은수로만들기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long res = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max < num) max = num;
            if (!stack.isEmpty()) {
                int p = stack.pop();
                if (p <= num) res += num - p;
            }
            stack.push(num);
        }

        // 마지막에 1 5 2 이렇게 끝나면 2의 경우 최댓값까지 올려주는 계산이 추가로 필요
        res += max - stack.pop();
        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
        br.close();
    }
}