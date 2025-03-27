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
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_10431_줄세우기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            List<Integer> height = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int TC = Integer.parseInt(st.nextToken());
            sb.append(TC).append(" ");

            int cnt = 0;
            for(int i = 1; i <= 20; i++) {
                int h = Integer.parseInt(st.nextToken());
                for(int j=height.size()-1; j>=0; j--) {
                    if(height.get(j) > h) cnt++;
                    else break;
                }
                height.add(h);
                Collections.sort(height);
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}