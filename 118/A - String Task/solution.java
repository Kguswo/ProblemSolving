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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Codeforces/C118A/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        List<Character> list = new ArrayList<>();
        list.add('A');
        list.add('O');
        list.add('Y');
        list.add('E');
        list.add('U');
        list.add('I');
 
        String str = br.readLine();
        str = str.toUpperCase();
 
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (list.indexOf(c) == -1) {
                sb.append('.').append(Character.toLowerCase(c));
            }
        }
 
        System.out.println(sb.toString());
 
        bw.flush();
        bw.close();
        br.close();
    }
}