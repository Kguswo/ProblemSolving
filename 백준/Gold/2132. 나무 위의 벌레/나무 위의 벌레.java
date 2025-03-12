/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, arr[];
    static List<Integer>[] board;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2132_나무위의벌레/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        board = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            board[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a].add(b);
            board[b].add(a);
        }

        int[] x = bfs(1);
        int[] y = bfs(x[0]);
        System.out.println(y[1] + " " + Math.min(x[0], y[0]));
        br.close();
    }

    private static int[] bfs(int start){
        int idx = 0;
        int maxD = Integer.MIN_VALUE;

        int[] sum = new int[N+1];
        Arrays.fill(sum, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        sum[start] = arr[start];
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(sum[curr] > maxD){
                maxD = sum[curr];
                idx = curr;
            }
            else if(sum[curr] == maxD){
                if(idx > curr) idx = curr;
                maxD = sum[curr];
            }

            for (int next : board[curr]) {
                if(sum[next] != -1) continue;
                sum[next] = sum[curr] + arr[next];
                queue.offer(next);
            }
        }

        return new int[] {idx, maxD};
    }
}
