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
    static int T, K;
    static String W;
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        //br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/BOJ_20437_문자열게임/input.txt")));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());

            // 문자열별 개수
            int[] count = new int[26];
            for(int i=0; i<W.length(); i++) {
                count[W.charAt(i) - 'a']++;
            }

            // K개짜리 정답 존재
            boolean flag = false;
            for(int i=0; i<26; i++) {
                if(count[i] >= K) {
                    flag = true;
                    break;
                }
            }

            if(!flag){
                sb.append("-1").append("\n");
                continue;
            }

            // 1번 답구하기
            int minLen = Integer.MAX_VALUE;
            int left=0, right = 0;
            int[] charCount = new int[26];
            
            while(right < W.length()) {
                char curr = W.charAt(right);
                charCount[curr - 'a']++;

                while(charCount[curr - 'a'] >= K) {
                    if(charCount[curr - 'a'] == K) {
                        minLen = Math.min(minLen, right-left+1);
                    }

                    charCount[W.charAt(left) - 'a']--;
                    left++;
                }

                right++;
            }

            // 2번답 구하기
            int maxLen = -1;
            Deque<Integer>[] K_len = new ArrayDeque[26];
            for(int i=0; i<26; i++) {
                K_len[i] = new ArrayDeque<>();
            }

            for(int i=0; i<W.length(); i++) {
                int curr = W.charAt(i)-'a';
                K_len[curr].add(i);

                if(K_len[curr].size() > K){
                    K_len[curr].pollFirst();
                }

                if(K_len[curr].size() == K){
                    int first = K_len[curr].peekFirst();
                    int last = K_len[curr].peekLast();
                    maxLen = Math.max(maxLen, last - first + 1);
                }
            }

            if(minLen == Integer.MAX_VALUE) sb.append("-1").append("\n");
            else sb.append(minLen).append(" ").append(maxLen).append("\n");
        }


        System.out.println(sb.toString());
        br.close();
    }
}