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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_12886_돌그룹/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean isAble = bfs(A, B, C);
        System.out.println(isAble ? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }

    private boolean bfs(int A, int B, int C) {
        int totalW = A + B + C;
        if (totalW % 3 != 0) return false;
        if (A == B && B == C) return true;

        int[] arr = new int[]{A, B, C};
        Arrays.sort(arr);

        boolean[][] visited = new boolean[totalW + 1][totalW + 1];
        Queue<int[]> queue = new LinkedList<>();
        visited[arr[0]][arr[1]] = true;
        queue.offer(new int[]{arr[0], arr[1], arr[2]});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int a = curr[0];
            int b = curr[1];
            int c = curr[2];

            List<int[]> list = new ArrayList<>();
            list.add(new int[]{a, b, totalW - a - b});
            list.add(new int[]{b, c, totalW - b - c});
            list.add(new int[]{c, a, totalW - c - a});

            for (int[] l : list) {
                int x = l[0];
                int y = l[1];
                if (x == y) continue;

                int nx, ny;
                if (x < y) {
                    nx = x + x;
                    ny = y - x;
                } else {
                    nx = x - y;
                    ny = y + y;
                }

                int next[] = {nx, ny, totalW - nx - ny};
                Arrays.sort(next);
                if (!visited[next[0]][next[1]]) {
                    if (next[0] == next[1] && next[1] == next[2]) return true;

                    visited[next[0]][next[1]] = true;
                    queue.offer(new int[]{next[0], next[1], next[2]});
                }
            }
        }
        return false;
    }
}