/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static String s1, s2;
    static Character[] koo, cube;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_16890_창업/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s1 = br.readLine();
        s2 = br.readLine();

        koo = new Character[s1.length()];
        cube = new Character[s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            koo[i] = s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            cube[i] = s2.charAt(i);
        }

        int N = s1.length();

        Arrays.sort(koo);
        Arrays.sort(cube);

        Deque<Character> dq_half_koo = new ArrayDeque<>();
        for (int i = 0; i < (N + 1) / 2; i++) {
            dq_half_koo.offer(koo[i]);
        }

        Deque<Character> dq_half_cube = new ArrayDeque<>();
        for (int i = N - N / 2; i < N; i++) {
            dq_half_cube.offer(cube[i]);
        }

        char[] res = new char[N];
        Arrays.fill(res, '?');

        int left = 0, right = N - 1;

        for (int i = 0; i < N; i++) {
            //koosaga턴
            if (i % 2 == 0) {
                if (!dq_half_cube.isEmpty() && dq_half_cube.peekLast() <= dq_half_koo.peekFirst()) {
                    // [D, E, F]
                    res[right--] = dq_half_koo.pollLast(); // ??'F'
                } else {
                    // [A, B, C]
                    res[left++] = dq_half_koo.pollFirst(); // 'A'??
                }
            }
            //cubelover턴
            else {
                if (!dq_half_koo.isEmpty() && dq_half_cube.peekLast() <= dq_half_koo.peekFirst()) {
                    // [A, B, C]
                    res[right--] = dq_half_cube.pollFirst(); // ?'A'F
                } else {
                    // [D, E, F]
                    res[left++] = dq_half_cube.pollLast(); // A'F' ?
                }
            }
        }
        System.out.println(new String(res));
        bw.flush();
        bw.close();
        br.close();
    }
}