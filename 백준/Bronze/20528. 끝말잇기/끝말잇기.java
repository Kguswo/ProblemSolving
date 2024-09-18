import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        String[] palindrome = br.readLine().split(" ");
        Set<Character> result = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            result.add(palindrome[i].charAt(0));
        }
        
        if (result.size() == 1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        br.close();
    }
}