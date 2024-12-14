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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_1094_막대기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());

        int res = Integer.bitCount(X);
        // int count = 0;
        // while (X > 0) {
        //     if ((X & 1) == 1) count++;
        //     X >>= 1;
        // }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}