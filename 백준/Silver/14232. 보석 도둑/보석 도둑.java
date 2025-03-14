/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long K;
    static List<Long> elements = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_14232_보석도둑/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Long.parseLong(br.readLine());

        long cnt = 0;
        long num = K;

        for (long i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                elements.add(i);
                num /= i;
                cnt++;
            }
        }

        if (num > 1) {
            elements.add(num);
            cnt++;
        }

        Collections.sort(elements);

        sb.append(cnt).append("\n");
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i)).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }
}