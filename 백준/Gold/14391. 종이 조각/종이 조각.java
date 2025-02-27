/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, M, board[][], max;
    static int[] dr = {0, 1}, dc = {1, 0};
    static int[] visited;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_14391_종이조각/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        // 가로 0, 세로 1
        for(int bitmask = 0; bitmask < (1<< (N*M)); bitmask++){
            int sum = 0;
            for(int i=0; i<N; i++) {
                int curr = 0;
                for(int j=0; j<M; j++) {
                    int bitPos = i * M + j;
                    if((bitmask & (1 << bitPos)) == 0) { // 가로
                        curr *= 10;
                        curr += board[i][j];
                    }
                    else{ // 세로
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }

            for(int j=0; j<M; j++) {
                int curr = 0;
                for(int i=0; i<N; i++) {
                    int bitPos = i * M + j;
                    if((bitmask & (1 << bitPos)) != 0) {
                        curr *= 10;
                        curr += board[i][j];
                    }
                    else{
                        sum += curr;
                        curr = 0;
                    }
                }
                sum += curr;
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
        bw.flush();
        bw.close();
        br.close();
    }
}