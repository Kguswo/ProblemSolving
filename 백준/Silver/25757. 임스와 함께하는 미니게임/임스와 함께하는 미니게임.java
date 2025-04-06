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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_25757_임스와함께하는미니게임/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int div = 0;
        if (game.equals("Y")) div = 1;
        else if (game.equals("F")) div = 2;
        else div = 3;

        Set<String> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            set.add(name);
        }

        int size = set.size();
        int res = size / div;

        System.out.println(res);

        br.close();
    }
}