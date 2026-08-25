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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Codeforces/C4A/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        if (n == 2) {
            System.out.println("NO");
        }
        else if (n % 2 == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
}