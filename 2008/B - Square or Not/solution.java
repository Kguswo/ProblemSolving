import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
         br = new BufferedReader(new InputStreamReader(System.in));
    //    br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            sb.append(squareOrNot(n, s) ? "Yes
" : "No
");
        }
 
        System.out.print(sb);
        br.close();
    }
 
    private static boolean squareOrNot(int n, String s) {
        int sqrtN = (int) Math.sqrt(n);
        
        // 제곱수 먼저 확인
        if (sqrtN * sqrtN != n) return false;
 
        // 가로 모서리 확인
        for (int i = 0; i < sqrtN; i++) {
            if (s.charAt(i) != '1' || s.charAt(n - sqrtN + i) != '1') return false;
        }
        
        // 세로 모서리 확인
        for (int i = 0; i < sqrtN; i++) {
            if (s.charAt(i * sqrtN) != '1' || s.charAt((i + 1) * sqrtN - 1) != '1') {
                return false;
            }
        }
 
        // 내부 0 확인
        if (sqrtN > 2) {
            for (int i = 1; i < sqrtN - 1; i++) {
                for (int j = 1; j < sqrtN - 1; j++) {
                    if (s.charAt(i * sqrtN + j) != '0') {
                        return false;
                    }
                }
            }
        }
 
        return true;
    }
}