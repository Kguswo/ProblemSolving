/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static Map<String, List<String>> music = new HashMap<>();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_31562_전주듣고노래맞히기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int T;
        String S, a;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            S = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<7; j++){
                a = st.nextToken();
                if(j<3) sb.append(a);
            }
            if(!music.containsKey(sb.toString())) music.put(sb.toString(), new ArrayList<>());
            List<String> name = music.get(sb.toString());
            name.add(S);
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = "";
            for(int j=0; j<3; j++){
                s += st.nextToken();
            }
            if(!music.containsKey(s)) res.append("!"+"\n");
            else {
                List<String> name = music.get(s);
                if(name.size() > 1) res.append("?"+"\n");
                else res.append(name.get(0)+"\n");
            }
        }

        System.out.println(res.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}