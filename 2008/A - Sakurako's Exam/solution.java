import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
 
        int t = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
 
            if (makeZero(a, b)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
 
        br.close();
    }
 
    public static boolean makeZero(int a, int b) {
        for (int i = -a; i <= a; i += 2) {
            for (int j = -2*b; j <= 2*b; j += 4) {
                if (i + j == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}