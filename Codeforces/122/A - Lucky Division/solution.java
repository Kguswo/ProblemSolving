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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Codeforces/C122A/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        List<Integer> luckyNums = new ArrayList<>();
 
        for (int i = 1; i <= 1000; i++) {
            String s = String.valueOf(i);
            boolean isLucky = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c != '4' && c != '7') {
                    isLucky = false;
                    break;
                }
            }
            if (isLucky) {
                luckyNums.add(i);
            }
        }
 
        int target = Integer.valueOf(str);
        boolean isAns = false;
        for (int i = 0; i < luckyNums.size(); i++) {
            if (target % luckyNums.get(i) == 0) {
                isAns = true;
                break;
            }
        }
 
        if (isAns) {
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