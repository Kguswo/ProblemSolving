/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int N, growth[];
    static long sum, res;

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_14247_나무자르기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        growth = new int[N];
        sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            growth[i] = Integer.parseInt(st.nextToken());
        }

        growth = Arrays.stream(growth)
                .sorted()
                .toArray();

//        System.out.println(Arrays.toString(growth));
        res = sum;
        for (int i = 0; i < N; i++) {
            res += growth[i] * i;
        }

        bw.write(Long.toString(res));
        bw.flush();
        bw.close();
        br.close();
    }
}