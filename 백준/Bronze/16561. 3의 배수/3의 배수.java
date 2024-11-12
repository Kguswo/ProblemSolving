/**
 * Author: nowalex322, Kim HyeonJae
 */
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int n;
    static int div; 
    
    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = read();
        div = n / 3;
        int cnt = 0;
        for (int i = 1; i < div; i++)
            for (int sub = i * 3, j = 1; j < div; j++)
                if (n - (sub + j * 3) >= 3) cnt++;
        bw.write(String.valueOf(cnt));
        bw.flush();
    }
    
    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}