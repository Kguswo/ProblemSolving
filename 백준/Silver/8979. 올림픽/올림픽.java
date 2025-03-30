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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_8979_올림픽/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][4];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
            board[i][3] = Integer.parseInt(st.nextToken());
        }

        int target = 0;
        for(int i = 0; i < n; i++) {
            if(board[i][0]==k){
                target = i;
                break;
            }
        }

        int res = 1;
        for(int i = 0; i < n; i++) {
            if(board[i][1] > board[target][1] ||
                    (board[i][1] == board[target][1] && board[i][2] > board[target][2]) ||
                    (board[i][1] == board[target][1] && board[i][2] == board[target][2] && board[i][3] > board[target][3])
            ) res++;
        }

        System.out.println(res);
        br.close();
    }
}