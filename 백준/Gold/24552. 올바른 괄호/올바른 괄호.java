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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_24552_올바른괄호/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int N = str.length() / 2 + 1;
        int cnt = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='(') cnt++;
            else cnt--;
        }

        // 지워야 하는 문양을 +1, 나머지문양을 -1
        // ( 가 많을때 왼쪽에서 오른쪽으로 진행. 음수 나오면 x, 0이상 나오도록 진행
        if(cnt>0){
            int prev=0;
            int toBeDeleted = 0;
            if(str.charAt(0) == '(') prev++;
            else if(str.charAt(0) == ')') prev--;

            for(int i=1; i<str.length(); i++) {
                int curr = prev;
                if(str.charAt(i) == '(') {
                    curr++;
                    toBeDeleted++;
                }
                else if(str.charAt(i) == ')') curr--;

                if(prev==0 && curr==1) {
                    N -= toBeDeleted;
                    toBeDeleted = 0;
                }
                prev = curr;
            }
        }
        // ) 가 많을때 오른쪽에서 왼쪽으로 진행. 음수 나오면 x, 0이상 나오도록 진행
        else if(cnt<0){
            int prev = 0;
            int toBeDeleted = 0;
            if(str.charAt(str.length()-1) == ')') prev++;
            else if(str.charAt(str.length()-1) == '(') prev--;

//            System.out.println("prev = " + prev);

            for(int i=str.length()-2; i>=0; i--) {
                int curr = prev;
                if(str.charAt(i) == ')') {
                    curr++;
                    toBeDeleted++;
                }
                else if(str.charAt(i) == '(') curr--;

                if(prev==0 && curr==1) {
                    N -= toBeDeleted;
                    toBeDeleted = 0;
                }
                prev = curr;
            }
        }
        System.out.println(N);
        bw.flush();
        bw.close();
        br.close();
    }
}