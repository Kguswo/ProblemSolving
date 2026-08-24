import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedReader br;
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
         br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
 
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            long l = Long.parseLong(input[0]);
            long r = Long.parseLong(input[1]);
 
            long maxLen = 0;
            long current = l;
            long difference = 1; // 처음 차이는 1로 설정
 
            while (current <= r) {
                maxLen++;
                current += difference;
                difference++;
            }
 
            sb.append(maxLen).append("
");
        }
 
        System.out.print(sb.toString());
 
        br.close();
    }
}