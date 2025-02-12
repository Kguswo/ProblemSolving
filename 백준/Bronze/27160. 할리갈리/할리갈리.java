/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Map<String, Integer> cards = new HashMap<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_27160_할리갈리/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cards.put("STRAWBERRY", 0);
        cards.put("BANANA", 0);
        cards.put("LIME", 0);
        cards.put("PLUM", 0);
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String card = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if(cards.containsKey(card)) {
                cards.put(card, cards.get(card) + value);
            }
        }
        boolean flag = false;
        for(String s : cards.keySet()) {
            if(cards.get(s) == 5) flag = true;
        }
        
        if(flag) System.out.println("YES");
        else System.out.println("NO");

        bw.flush();
        bw.close();
        br.close();
    }
}