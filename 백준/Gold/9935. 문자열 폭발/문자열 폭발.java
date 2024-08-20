import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static String str, bomb;
    static Deque<Character> deque = new ArrayDeque<Character>();
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        bomb = br.readLine(); 

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
            if (deque.size() >= bomb.length()) {
                isBombExist();
            }
        }
        
        bw.write(deque.isEmpty() ? "FRULA" : makeAns());

        bw.flush();
        bw.close();
        br.close();
    }

    private static void isBombExist() {
        if (deque.size() < bomb.length()) return;

        List<Character> temp = new ArrayList<>();
        boolean isBomb = true;

        for (int i = 0; i < bomb.length(); i++) {
            char c = deque.removeLast();
            temp.add(c);
            if (c != bomb.charAt(bomb.length() - 1 - i)) {
                isBomb = false;
                break;
            }
        }

        if (!isBomb) {
            for (int i = temp.size() - 1; i >= 0; i--) {
                deque.addLast(temp.get(i));
            }
        }
    }
    
    private static String makeAns() {
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}