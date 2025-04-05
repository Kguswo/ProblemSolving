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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_4659_비밀번호발음하기/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if(s.equals("end")) {
                System.out.println(sb.toString());
                break;
            }
            else {
                char c = s.charAt(0);
                boolean flag;
                flag = check(s);
                sb.append("<").append(s).append("> is ");
                if(!flag) sb.append("not ");
                sb.append("acceptable.\n");
            }
        }

        br.close();
    }

    private boolean check(String s) {
        boolean hasVowel = false;
        int vowelCnt = 0; // 모음
        int consonantCnt = 0; // 자음

        char prevC = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                hasVowel = true;
                vowelCnt++;
                consonantCnt = 0;
            } else {
                consonantCnt++;
                vowelCnt = 0;
            }

            // 모음 또는 자음이 3개 연속 체크
            if (vowelCnt >= 3 || consonantCnt >= 3) {
                return false;
            }

            // 같은 글자가 연속 체크 (ee, oo 제외)
            if (i > 0 && c == prevC) {
                if (!(c == 'e' || c == 'o')) {
                    return false;
                }
            }
            prevC = c;
        }
        return hasVowel;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
