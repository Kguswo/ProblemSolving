/**
 * Author: nowalex322, Kim HyeonJae
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_4889_안정적인문자열/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int tc = 1;
        while(true) {
            String line = br.readLine();

            if(line.charAt(0) == '-') break;

            int res = getAns(line);
            sb.append(tc++).append(". ").append(res).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int getAns(String str) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);

            if(curr == '{') stack.push(curr);
            else{
                if(stack.isEmpty()){
                    cnt++;
                    stack.push('{'); // 닫는 괄혼데 비어있으면 여는걸로 바꿔서넣기
                }
                else stack.pop();
            }
        }

        //스택에는 여는 괄호만 남았음
        return cnt + stack.size()/2;
    }
}