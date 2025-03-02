/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int R, C;
    static String[] lines;
    static ArrayList<String> words;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_2866_문자열잘라내기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        lines = new String[R];
        words = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            lines[i] = br.readLine();
        }

        for(int j = 0; j < C; j++) {
            sb = new StringBuilder();
            for (int i = 0; i < R; i++) {
                sb.append(lines[i].charAt(j));
            }
            words.add(sb.toString());
        }

        Set<String> set;
        for (int i = 0; i < R; i++) {
            set = new HashSet<>();
            for (String s: words) {
                String substring = s.substring(i);
                if(!set.add(substring)) {
                    System.out.println(i-1);
                    return;
                }
            }
        }
        System.out.println(R - 1);
        bw.flush();
        bw.close();
        br.close();
    }
}