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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Codeforces/C69A/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int n = Integer.parseInt(br.readLine());
 
        int x = 0;
        int y = 0;
        int z = 0;
 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x += Integer.parseInt(st.nextToken());
            y += Integer.parseInt(st.nextToken());
            z += Integer.parseInt(st.nextToken());
        }
        if (x == 0 && y == 0 && z == 0) {
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