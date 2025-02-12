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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_10798_세로읽기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char[][] board = new char[5][15];
        for(int i=0; i<5; i++){
            for(int j=0; j<15; j++){
                board[i][j] = '*';
            };
        }
        for(int i=0; i<5; i++){
            String s = br.readLine();
            for(int j=0; j<s.length(); j++){
                board[i][j] = s.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<15; j++){
            for(int i=0; i<5; i++){
                if(board[i][j] != '*') sb.append(board[i][j]);
            }
        }
//        for(int i=0; i<5; i++){
//            System.out.println(Arrays.toString(board[i]));
//        }
        System.out.println(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}