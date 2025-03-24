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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_11723_집합/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set.add(x);
            }
            else if(command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set.remove(x);
            }
            else if(command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)) sb.append("1").append('\n');
                else sb.append("0").append('\n');
            }
            else if(command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)) set.remove(x);
                else set.add(x);
            }
            else if(command.equals("all")) {
                List<Integer> list = new ArrayList<>();
                for(int i=1; i<=20; i++) list.add(i);
                set = new HashSet<>(list);
            }
            else if(command.equals("empty")) {
                set.clear();
            }
        }
        System.out.println(sb.toString());
        br.close();
    }
}