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
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_5052_전화번호목록/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                String num = br.readLine();
                s[i] = num;
            }

            Arrays.sort(s);

            boolean flag = true;
            for (int i = 0; i < s.length - 1; i++) {
                if (s[i + 1].startsWith(s[i])) {
                    flag = false;
                    sb.append("NO").append("\n");
                    break;
                }
            }
            if (flag) {
                sb.append("YES").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
}