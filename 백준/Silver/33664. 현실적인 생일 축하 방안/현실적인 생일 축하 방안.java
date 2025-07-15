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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Happy_Birthday_Lumi_2025/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Long> items = new HashMap<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long price = Long.parseLong(st.nextToken());
            items.put(name, price);
        }

        long cost = 0;
        for (int i=0; i<M; i++) {
            String nameToBuy = br.readLine();
            cost += items.get(nameToBuy);
        }

        if(cost <= B) System.out.println("acceptable");
        else System.out.println("unacceptable");
        
        

        bw.flush();
        bw.close();
        br.close();
    }
}