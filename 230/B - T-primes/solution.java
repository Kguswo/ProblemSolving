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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Codeforces/C230B/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = sieve(1_000_000);
 
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            long m = Long.parseLong(st.nextToken());
            long root = (long) Math.sqrt(m);
            boolean isAnswer = false;
 
            if (root * root == m && isPrime[(int) root]) {
                isAnswer = true;
            }
 
            sb.append(isAnswer ? "YES" : "NO").append("
");
        }
 
        System.out.println(sb.toString());
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    private boolean[] sieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
 
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
 
        return isPrime;
    }
}