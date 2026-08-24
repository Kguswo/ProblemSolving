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
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        String input = br.readLine();
        String[] split = new String[0];
        split = input.split("\\+");
 
        Arrays.sort(split);
 
        StringBuilder sb = new StringBuilder();
        sb.append(split[0]);
 
        for (int i = 1; i < split.length; i++) {
            sb.append("+").append(split[i]);
        }
 
        System.out.println(sb.toString());
 
        bw.flush();
        bw.close();
        br.close();
    }
}