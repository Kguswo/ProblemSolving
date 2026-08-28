/**
 * Author: nowalex322, Kim HyeonJae
 */
 
import java.io.*;
import java.util.*;
 
public class Main {
 
    class Dragon implements Comparable<Dragon> {
        int xi;
        int yi;
 
        public Dragon(int xi, int yi) {
            this.xi = xi;
            this.yi = yi;
        }
 
        @Override
        public int compareTo(Dragon o) {
            return this.xi - o.xi;
        }
    }
 
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
 
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
 
    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Codeforces/C230A/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        st = new StringTokenizer(br.readLine());
 
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Dragon> dragons = new ArrayList<Dragon>();
        boolean flag = true;
 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());
            dragons.add(new Dragon(xi, yi));
        }
 
        Collections.sort(dragons);
 
        for (Dragon dragon : dragons) {
            if (dragon.xi < s) {
                s += dragon.yi;
            }
            else {
                flag = false;
                break;
            }
        }
        
        if (flag) {
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