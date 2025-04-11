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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_20125_쿠키의신체측정/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        int[] head = new int[2];
        boolean firstStar = false;

        int[] heart = new int[2];

        int armLen = 0;

        int[] belly = new int[2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '*' && !firstStar) {
                    firstStar = true;
                    head[0] = i;
                    head[1] = j;
                }

                if (board[i][j] == '*') {
                    cnt++;
                    if (cnt >= 3) {
                        heart[0] = i;
                        heart[1] = head[1];
                    }
                }
                if (i == heart[0]) armLen = cnt;
            }
        }

        int legR = 0;
        for (int i = head[0]; i < N; i++) {
            if (board[i][head[1]] != '*') {
                legR = i;
                break;
            }
        }
        belly[1] = head[1];
        belly[0] = legR - 1;

        List<Integer> l_list = new ArrayList<>();
        for (int j = head[1] - 1; j <= head[1] + 1; j += 2) {
            int l_cnt = 0;
            for (int i = legR; i < N; i++) {
                if (board[i][j] == '*') {
                    l_cnt++;
                } else break;
            }
            l_list.add(l_cnt);
        }

        int a_cnt = 0;
        for (int j = 0; j < N; j++) {
            if (j >= (heart[1] + 1) && board[heart[0]][j] == '*') {
                a_cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        sb.append(armLen - (1 + a_cnt)).append(" ").append(a_cnt).append(" ").append(belly[0] - heart[0]).append(" ").append(l_list.get(0)).append(" ").append(l_list.get(1));
        System.out.println(sb.toString());

        br.close();
    }
}
