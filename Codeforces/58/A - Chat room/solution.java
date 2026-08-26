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
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/Codeforces/C58A/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        boolean flag = true;
        List<Character> target = new ArrayList<>();
        target.add('h');
        target.add('e');
        target.add('l');
        target.add('l');
        target.add('o');
 
        int targetIdx = 0;
        int watchingIdx = 0;
 
        String curr;
 
        while (watchingIdx < str.length() && targetIdx < 5) {
            if (str.charAt(watchingIdx) == target.get(targetIdx)){
                targetIdx++;
            }
            watchingIdx++;
        }
 
        if (targetIdx < 5) {
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
}